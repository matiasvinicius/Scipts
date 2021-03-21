#Validate parameters of functions best and rank hospital
validateParameters <- function(dataset, state, outcome){
  #Creates a vector with the states included at dataset
  validStates<- unique(dataset$State)
  
  #Verify if outcome or state are invalid
  if(!is.element(outcome, c("heart attack", "heart failure", "pneumonia"))){
    stop("invalid outcome")
  }
  if(!is.element(state,validStates)){
    stop("invalid state")
  }
}
