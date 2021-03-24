library(plyr)
library(dplyr)
library(ggplot2)

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

# How have emissions from motor vehicle sources changed from 
# 1999-2008 in Baltimore City?
plot6 <- function() {
  download_data()
  
  if (!dir.exists("images")){
    message("Creating folder 'images'")
    dir.create("images")
  }
  
  message("Loading the rds files")
  NEI <- readRDS("./data/summary_SCC.rds") %>%
    filter(type == "ON-ROAD",
           fips %in% c("24510","06037")) %>%
    select(Emissions, year, fips) %>%
    group_by(fips, year) %>%
    summarise(Emissions = sum(Emissions), .groups = "drop")
  
  NEI$fips <- mapvalues(NEI$fips, 
                        from = c("24510","06037"),
                        to = c("Baltimore City", "Los Angeles, California"))
  
  ggplot(data = NEI, aes(x = as.factor(year), y = Emissions)) + 
    geom_bar(stat = "identity") +
    facet_wrap(. ~ fips) +
    ylab("Emissions (tons)") + 
    xlab("Year") + 
    ggtitle("Emissions from motor vehicle sources (1999-2008)") + 
    theme(plot.title = element_text(hjust = 0.5))
}

png('images/plot6.png')
plot6()
dev.off()
message("plot6.png saved in 'images' directory")
