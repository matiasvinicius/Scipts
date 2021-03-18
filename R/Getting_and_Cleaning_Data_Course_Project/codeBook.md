# Code Book
Este arquivo contém uma apresentação do formato das variáveis e seus possíveis valores

## Identificadores
- `subject`: Id do sujeito que os dados se referem. São 30 pessoas no estudo, logo, os valores inteiros possíveis variam de 1 à 30.
- `status`: Status de atividade que a pessoa tinha quando as medidas foram coletadas. Existem 6 valores possíveis (note que as strings são autoexplicativas):
  - WALKING
  - WALKING_UPSTAIRS
  - WALKING_DOWNSTAIRS
  - SITTING
  - STANDING
  - LAYING

## Estatísticas
Foram tomadas as estatísticas de média e desvio padrão para extrair os resultados. Os valores numéricos normalizados (ou seja, no intervalo entre -1 e 1) foram extraidos o acelerometro ou giroscópio do smartphone para os eixos do espaço tridimensional (X, Y e Z). Especifidades sobre os cálculos das medidas podem ser coletados do [repositório original](https://archive.ics.uci.edu/ml/datasets/Human+Activity+Recognition+Using+Smartphones).
Resumidamente, os atributos seguem os padrões de nomenclatura abaixo, variando as informações contidas de acordo com o objetivo da variável: 
- O prefixo `t` refere-se à medida de tempo (em taxa constante de 50 Hz) e o prefixo `f` à frequência (pela Fast Fourier Transform);
- `Body` são medidas sobre o corpo e `Gravity` sobre a aceleração da gravidade;
- `Acc` faz referência à medidas do acelerômetro e `Gyro` às medidas do giroscópio;
- `Jerk` são sinais de empurrão;
- `Mag` é a maginutde dos eixos X, Y e Z pela norma euclidiana;
- `Mean` são médias, `MeanFreq` médias de frequência e `Std` desvios padrão;
- Os sufixos `X`, `Y` e `Z` referêm-se ao eixo do espaço tridimensional que a variável foi coletada.

Os atributos são os seguintes:

- `subject`
- `status`
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

## Sobre as transformações
As colunas de estatísticas se diferem dos dados originais pela remoção do `-` e dos `()` para manter a consistência com o resto das strings.
