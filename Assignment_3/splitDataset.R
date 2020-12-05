#Return the columns with hospital name, state and
#another provided by user from dataset outcome-of-care-measures.csv 
splitDataset <- function(dataset, columnOutcome){
  splitData <- dataset[c(2,7,columnOutcome)]
  return(splitData)
} 
