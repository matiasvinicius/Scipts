#Return the Hospital with lowest 30-day mortality for a specified outcome 
best <- function(state, outcome){
  source("rankhospital.R")
  return(rankhospital(state, outcome))
}
