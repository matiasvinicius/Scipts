library(dplyr)
library(ggplot2)
library(gridExtra)

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

type_plot <- function(data, title) {
  plot <- ggplot(data, aes(x = year, y = Emissions)) + 
    geom_line() +
    geom_label(label = data$year) + 
    ggtitle(title) +
    theme(plot.title = element_text(hjust = 0.5),
          axis.title.x=element_blank(),
          axis.text.x=element_blank(),
          axis.ticks.x=element_blank())
  
  plot
}

# Of the four types of sources indicated by the type (point, nonpoint, onroad, 
# nonroad) variable, which of these four sources have seen decreases in 
# emissions from 1999 - 2008 for Baltimore City? Which have seen increases in 
# emissions from 1999 - 2008? Use the ggplot2 plotting system to make a plot 
# answer this question.
plot3 <- function() {
  download_data()
  
  if (!dir.exists("images")){
    message("Creating folder 'images'")
    dir.create("images")
  }
  
  message("Loading the rds files")
  NEI <- readRDS("./data/summary_SCC.rds") %>%
    filter(fips == "24510") %>%
    select(type, Emissions, year) %>%
    group_by(type, year) %>%
    summarize(Emissions = sum(Emissions), .groups = "drop")
  
  source_types <- unique(NEI$type)
  plots <- list()
  
  for (source_type in source_types) {
    message("Creating ", source_type, " plot")
    plot_data <- NEI %>% 
      filter(type == source_type) %>%
      filter(year == c(1999, 2008)) %>%
      select(-type)
    
    plot <- type_plot(plot_data, source_type)
   
    plots[[source_type]] <- plot
  }
  
  message("Crating final plot")
  
  png('images/plot3.png', width = 1366, height = 720, units = "px")
  grid.arrange(plots$`NON-ROAD`,
               plots$NONPOINT,
               plots$`ON-ROAD`,
               plots$POINT,
               top = "Increase in POINT source type emissions (1999 and 2008)")
  dev.off()
  
  message("plot3.png saved in 'images' directory")
}

plot3()
