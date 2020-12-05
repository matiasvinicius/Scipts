#Returns "num" line of first collumn (Hospital Name) of a ranking of hospitals from rankhospital()
chooseRankHospital <- function(dataset, num){
  if(num=="best"){
    return (head(dataset,1)[1,1])
  }
  else if (num == "worst"){
    return(tail(dataset,1)[1,1])
  }
  else if (num <= nrow(dataset)){
    return (dataset[num,1])
  }
  return(NA)
}

