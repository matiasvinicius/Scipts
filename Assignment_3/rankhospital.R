#Returns a character vector with the name of the hospital that has the ranking specified by the num argument 
rankhospital <- function(state, outcome, num = "best") {
  source("validateParameters.R")
  source("splitDataset.R")
  source("chooseRankHospital.R")
  
  dataset<- read.csv("outcome-of-care-measures.csv", colClasses = "character")
  validateParameters(dataset, state, outcome)
  
  #If the outcome is "heart attack", the collumn 13 of this dataset will return us the
  #Lower Mortality Estimate by heart attack in 30 days
  if(outcome == "heart attack"){
    splitData <- splitDataset(dataset, 11)
  }
  else if (outcome == "heart failure"){
    splitData <- splitDataset(dataset, 17)
  }
  else{
    splitData <- splitDataset(dataset, 23)
  }
  
  #Leaves the dataset only with the state provided
  correctState <- splitData$State == state
  splitData <- splitData[correctState,]
  
  #Remove missing data of column with mortality
  missingData <- is.na(as.numeric(splitData[,3]))
  missingData
  splitData <- splitData[!missingData,]
  
  #Order dataset by Hospital Name (alfabetic order)
  #Then order by mortality estimate
  splitData <- splitData[order(splitData[,1]),]
  splitData <- splitData[order(as.numeric(splitData[,3])),]
  
  hospitalName <- chooseRankHospital(splitData, num)
  
  return (hospitalName)
  
}

