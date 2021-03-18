# Code Book
This file contains a presentation of the format of the variables and their possible values.

## Identifiers
- `subject`: Id of the subject that the data refer to. There are 30 people in the study, so the possible whole values range from 1 to 30.
- `status`: Activity status that the person had when measurements were collected. There are 6 possible values (note that strings are self-explanatory):
  - WALKING
  - WALKING_UPSTAIRS
  - WALKING_DOWNSTAIRS
  - SITTING
  - STANDING
  - LAYING

## Statistics
Mean and standard deviation statistics were taken to extract the results. The normalized numerical values (that is, in the range between -1 and 1) were extracted from the accelerometer or gyroscope of the smartphone for the axes of three-dimensional space (X, Y and Z). Specifics about the measurement calculations can be collected from the [original repository](https://archive.ics.uci.edu/ml/datasets/Human+Activity+Recognition+Using+Smartphones).
Briefly, the attributes follow the nomenclature patterns below, varying the information contained according to the purpose of the variable:

- The prefix `t` refers to the measurement of time (at a constant rate of 50 Hz) and the prefix `f` to the frequency (by Fast Fourier Transform);
- `Body` are measures on the body and `Gravity` on the acceleration of gravity;
- `Acc` refers to the measurements of the accelerometer and `Gyro` to the measurements of the gyroscope;
- `Jerk` are signs of pushing / jerk;
- `Mag` is the magnitude of the X, Y and Z axes according to the Euclidean norm;
- `Mean` are averages, `MeanFreq` average frequencies and `Std` standard deviations;
- The suffixes `X`, `Y` and `Z` refer to the axis of the three-dimensional space in which the variable was collected.

The attributes are as follows:

- `tBodyAccMeanX`
- `tBodyAccMeanY`
- `tBodyAccMeanZ`
- `tBodyAccStdX`
- `tBodyAccStdY`
- `tBodyAccStdZ`
- `tGravityAccMeanX`
- `tGravityAccMeanY`
- `tGravityAccMeanZ`
- `tGravityAccStdX`
- `tGravityAccStdY`
- `tGravityAccStdZ`
- `tBodyAccJerkMeanX`
- `tBodyAccJerkMeanY`
- `tBodyAccJerkMeanZ`
- `tBodyAccJerkStdX`
- `tBodyAccJerkStdY`
- `tBodyAccJerkStdZ`
- `tBodyGyroMeanX`
- `tBodyGyroMeanY`
- `tBodyGyroMeanZ`
- `tBodyGyroStdX`
- `tBodyGyroStdY`
- `tBodyGyroStdZ`
- `tBodyGyroJerkMeanX`
- `tBodyGyroJerkMeanY`
- `tBodyGyroJerkMeanZ`
- `tBodyGyroJerkStdX`
- `tBodyGyroJerkStdY`
- `tBodyGyroJerkStdZ`
- `tBodyAccMagMean`
- `tBodyAccMagStd`
- `tGravityAccMagMean`
- `tGravityAccMagStd`
- `tBodyAccJerkMagMean`
- `tBodyAccJerkMagStd`
- `tBodyGyroMagMean`
- `tBodyGyroMagStd`
- `tBodyGyroJerkMagMean`
- `tBodyGyroJerkMagStd`
- `fBodyAccMeanX`
- `fBodyAccMeanY`
- `fBodyAccMeanZ`
- `fBodyAccStdX`
- `fBodyAccStdY`
- `fBodyAccStdZ`
- `fBodyAccMeanFreqX`
- `fBodyAccMeanFreqY`
- `fBodyAccMeanFreqZ`
- `fBodyAccJerkMeanX`
- `fBodyAccJerkMeanY`
- `fBodyAccJerkMeanZ`
- `fBodyAccJerkStdX`
- `fBodyAccJerkStdY`
- `fBodyAccJerkStdZ`
- `fBodyAccJerkMeanFreqX`
- `fBodyAccJerkMeanFreqY`
- `fBodyAccJerkMeanFreqZ`
- `fBodyGyroMeanX`
- `fBodyGyroMeanY`
- `fBodyGyroMeanZ`
- `fBodyGyroStdX`
- `fBodyGyroStdY`
- `fBodyGyroStdZ`
- `fBodyGyroMeanFreqX`
- `fBodyGyroMeanFreqY`
- `fBodyGyroMeanFreqZ`
- `fBodyAccMagMean`
- `fBodyAccMagStd`
- `fBodyAccMagMeanFreq`
- `fBodyBodyAccJerkMagMean`
- `fBodyBodyAccJerkMagStd`
- `fBodyBodyAccJerkMagMeanFreq`
- `fBodyBodyGyroMagMean`
- `fBodyBodyGyroMagStd`
- `fBodyBodyGyroMagMeanFreq`
- `fBodyBodyGyroJerkMagMean`
- `fBodyBodyGyroJerkMagStd`
- `fBodyBodyGyroJerkMagMeanFreq`

## About the transformations
The measurement columns differ from the original data by removing `-` and `()` to maintain consistency with the rest of the strings.
