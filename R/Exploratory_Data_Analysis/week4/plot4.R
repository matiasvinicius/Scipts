library(dplyr)
library(ggplot2)
library(stringr)

download_data <- function() {
  if(!dir.exists("data")) {
    message("Creating folder 'data'")
    dir.create("data")
    url <- "https://d396qusza40orc.cloudfront.net/exdata%2Fdata%2FNEI_data.zip"
    
    download.file(url, destfile = "data/emissions_data.zip")
    unzip("data/emissions_data.zip")
    file.rename(from = "Source_Classification_Code.rds", to = "data/SCC.rds")
    file.rename(from = "summarySCC_PM25.rds", to = "data/summary_SCC.rds")
    file.remove("data/emissions_data.zip")
    
    message("rds files downloaded in './data/'")
  }
}

# Across the United States, how have emissions from coal combustion-related 
# sources changed from 1999 - 2008?
plot4 <- function() {
  download_data()
  
  if (!dir.exists("images")){
    message("Creating folder 'images'")
    dir.create("images")
  }
  
  message("Loading the rds files")
  SCC <- readRDS("./data/SCC.rds")
  SCC_summary <- readRDS("./data/summary_SCC.rds")

  SCC_coal <- str_detect(SCC$Short.Name, "coal|Coal")
  SCC_coal <- SCC$SCC[SCC_coal]
  coal_data <- SCC_summary[SCC_summary$SCC %in% SCC_coal,]

  coal_data <- coal_data %>%
    select(Emissions, year) %>%
    group_by(year) %>%
    summarise(Emissions = sum(Emissions), .groups = "drop")
  
  g <- ggplot(data = coal_data, aes(x = as.factor(year), y = Emissions)) +
    geom_bar(stat = "identity") + 
    xlab("Year") + 
    ggtitle("Change in coal emissions related to combustion
            sources from 1999 to 2008") + 
    theme(plot.title = element_text(hjust = 0.5))
    
  return (g)
}

png('images/plot4.png', width = 1366, height = 720, units = "px")
plot4()
dev.off()
message("plot4.png saved in 'images' directory")
