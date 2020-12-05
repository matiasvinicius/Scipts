#Take the hospital from every state that are ranked at "num" position of Lowest mortality of "outcome" 
rankall <- function(outcome, num = "best") {
  source("splitDataset.R")
  source("chooseRankHospital.R")
  
  dataset<- read.csv("outcome-of-care-measures.csv", colClasses = "character")
  validStates<- unique(dataset$State)
  
  #Verify if outcome or state are invalid
  if(!is.element(outcome, c("heart attack", "heart failure", "pneumonia"))){
    stop("invalid outcome")
  }

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
  
  #Remove missing data
  missingData <- is.na(as.numeric(splitData[,3]))
  missingData
  splitData <- splitData[!missingData,]
  
  #These variables will have the values of the final ranking 
  columnState <- c()
  columnHospitalName <- c()
  
  
  #We take a vector with all the states of the dataset (without repetitions) to compare with the states of the original dataset.
  #For each state, we separate the dataset and check which has the lowest mortality rate.
  #We store the hospital name and state to create a rankinh data fram
  i <- 1
  while (i < length(validStates)){
    currentState <- splitData$State == validStates[i]
    currentData <- splitData[currentState,]
    
    currentData <- currentData[order(currentData[,1]),]
    currentData <- currentData[order(as.numeric(currentData[,3])),]
    
    columnHospitalName <- c(columnHospitalName, chooseRankHospital(currentData, num))
    columnState <- c(columnState, validStates[i])
    
    i <- i + 1
  }
  
  #Create the datadrame with the ranking data and reorder by alfabetic order (by state)
  ranking <- data.frame(state = columnState, hospital = columnHospitalName)
  ranking <- ranking[order(ranking[,1]),]
  
  
  return(ranking)
}