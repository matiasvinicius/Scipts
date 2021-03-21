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

# Have total emissions from PM2.5 decreased in the Baltimore City, Maryland 
# (fips == "24510") from 1999 to 2008? Use the base plotting system 
# to make a plot answering this question.
plot2 <- function() {
  download_data()
  
  if (!dir.exists("images")){
    message("Creating folder 'images'")
    dir.create("images")
  }
  
  message("Loading the rds files")
  summary_SCC <- readRDS("./data/summary_SCC.rds") %>%
    filter(fips == "24510") %>%
    select(Emissions, year) %>%
    group_by(year) %>%
    summarize(Emissions = sum(Emissions))
    
  png('images/plot2.png')
  
  plot(summary_SCC$Emissions ~ summary_SCC$year,
       type = "c",
       xaxt= 'n',
       xlab = "Year",
       ylab = "Total PM2.5 emissions",
       main = "Total PM2.5 emissions in Baltimore City, 
       Maryland decrease (1999-2008)")

  text(summary_SCC$Emissions ~ summary_SCC$year, 
       labels = summary_SCC$year, cex=0.9, font=2)
  
  dev.off()
  
  message("plot2.png saved in 'images' directory")
}

plot2()