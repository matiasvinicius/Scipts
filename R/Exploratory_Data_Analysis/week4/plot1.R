library(dplyr)

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

# Have total emissions from PM2.5 decreased in the United States from 1999 to 
# 2008? Using the base plotting system, make a plot showing the total 
# PM2.5 emission from all sources for each of the years 1999, 2002, 2005, 
# and 2008.
plot1 <- function() {
  download_data()
  
  if (!dir.exists("images")){
    message("Creating folder 'images'")
    dir.create("images")
  }
  
  message("Loading the rds files")
  summary_SCC <- readRDS("./data/summary_SCC.rds") %>%
    select(Emissions, year) %>%
    group_by(year) %>%
    summarize(Emissions = sum(Emissions))
  
  png('images/plot1.png')
  barplot(summary_SCC$Emissions/10^6 ~ summary_SCC$year,
       xlab = "Year",
       ylab = "Total PM2.5 emissions (millions)",
       main = "Total PM2.5 emissions decrease (1999-2008)")
  dev.off()
  
  message("plot.png saved in 'images' directory")
}

plot1()