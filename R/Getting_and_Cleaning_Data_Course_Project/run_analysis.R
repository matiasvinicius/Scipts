library(plyr)
library(dplyr)
library(stats)
library(stringr)

download_data <- function(){
  if(!dir.exists("UCI HAR Dataset")) {
    #url from http://archive.ics.uci.edu/ml/datasets/Human+Activity+Recognition+Using+Smartphones
    url <- "https://d396qusza40orc.cloudfront.net/getdata%2Fprojectfiles%2FUCI%20HAR%20Dataset.zip"
    download.file(url, destfile = "data.zip")
    
    unzip("data.zip")
    file.remove("data.zip")
    message("Created folder 'UCI HAR Dataset' with the data")
  }
}

build_tibble <- function(folder_path, features_names, features_indexes, set) {
  data <- paste(folder_path, "X_", set, ".txt", sep = "") %>%
    read.table(header = FALSE) %>% 
    select(features_indexes)

  colnames(data) <- features_names
  
  status <- paste(folder_path, "y_", set, ".txt", sep = "") %>%
    read.table(header = FALSE) %>%
    unlist()
  
  subject <- paste(folder_path, "subject_", set, ".txt", sep = "") %>%
    read.table(header = FALSE) %>%
    unlist()   
  
  tibble(data, status, subject)
}

run_analysis <- function() {
  message("Verifying if the data is visible by the function")
  download_data()
  
  message("Getting important features data")
  features <- read.table("UCI HAR Dataset/features.txt") 
  features_pattern <- "(mean|std)"
  
  features_indexes <- str_which(features$V2, features_pattern)

  features_names <- str_subset(features$V2[features_indexes], 
                               features_pattern) %>%
    str_remove_all("\\(\\)") %>%
    str_replace_all("-", "_")
    
  message("Extracting test data")
  folder_path <- "UCI HAR Dataset/test/"
  test <- build_tibble(folder_path, features_names, features_indexes, "test")
  
  message("Extracting train data")
  folder_path <- "UCI HAR Dataset/train/"
  train <- build_tibble(folder_path, features_names, features_indexes, "train")
  
  message("Merge test and train data")
  data <- bind_rows(test, train) %>%
    select(subject, status, everything()) #Subject and status are now the first columns

  message("Change status (labels) identifier")
  file <- "UCI HAR Dataset/activity_labels.txt"
  
  meaning_label <- read.delim(file, header = FALSE, sep = " ")
  colnames(meaning_label) <- c("id", "name")
  
  data$status <- mapvalues(data$status, 
                    from = meaning_label$id, to = meaning_label$name)
  
  data 
}

data <- run_analysis()


tidy_data <- function(data) {
  message("Creating the tidy data")
  data <- data %>%
    group_by(subject, status) %>% 
    summarise(across(everything(), list(mean)))
  
  colnames(data) <- str_remove_all(names(data), "_1") #Removing sufix
  
  data
}

new_data <- tidy_data(data)
message("Creating txt file with the tidy data")
write.table(new_data, file = "tidy_data.txt", sep = ";", row.names = FALSE) 

