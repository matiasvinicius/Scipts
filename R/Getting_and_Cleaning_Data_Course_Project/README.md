# Introdução
Este repositório contém o projeto final do curso [Getting and Cleaning Data](https://www.coursera.org/learn/data-cleaning) oferecido pela universidade Johns Hopkins na plataforma Coursera.
O objetivo do trabalho é tratar um conjunto de arquivos coletados por [acelerometros pelo smartphone Samsung Galaxy S](http://archive.ics.uci.edu/ml/datasets/Human+Activity+Recognition+Using+Smartphones) para resultar em um único conjunto de dados com os registros de média e desvio padrão para cada uma das características identificas.
Abaixo estão parafraseados os 5 passos requeridos para o projeto:

1. Merges the training and the test sets to create one data set.
2. Extracts only the measurements on the mean and standard deviation for each measurement. 
3. Uses descriptive activity names to name the activities in the data set
4. Appropriately labels the data set with descriptive variable names. 
5. From the data set in step 4, creates a second, independent tidy data set with the average of each variable for each activity and each subject.

# Arquivos
O repositório contém 4 arquivos:
1. run_analysis.R: O script que contém todas as funções para coleta, tratamento dos dados e geração do arquivo tidy_data.txt
2. codeBook.md: Descrição das variáveis e da limpeza dos dados realizadas pelo arquivo run_analysis.R
3. README.md: Arquivo de descrição do projeto
4. tidy_data.txt: o arquivo gerado pela execução do script run_analysis.R. Pode ser deletado, sendo que será criado novamente na execução do script.

# run_analyis.R
O arquivo começa carregando os pacotes que serão utilizados na análise (ver requerimentos), a partir daí se tem uma sequência de funções:
1. `download_data()`: Verifica se os dados estão no repositório (isto é, se existe uma pasta chamada "UCI HAR Dataset" visível), se não houver será realizado o download dos dados e criada a nova pasta com os arquivos.

2. `build_tibble(folder_path, features_names, features_indexes, set)`: Visto que existe uma grande semelhança no processo realizado para limpar os dados de treino e de teste, foi criada uma função que realiza esse processo para evitar duplicação. Essa função é chamada pela função `run_analysis()` e tem quatro argumentos:
- folder_path: Caminho para a pasta de treino ("UCI HAR Dataset/train/"), ou para a pasta de teste ("UCI HAR Dataset/test/")
- features_names: Nomes das variáveis que serão capturadas
- features_indexes: Índices variáveis que serão capturadas
- set: "train" ou "test"
A função primeiro lê o arquivo com todos os dados coletados ("X_train" ou "X_test", dependendo do valor do parâmetro set) e extrai as colunas com as informações necessárias e seus respectivos nomes. Em sequência são lidos os valores do status de atividade e de subject para serem unidos em um único conjunto de dados de treino ou teste.

3. `run_analysis()`: É a função que retornará o conjunto de dados requerido até o passo 4. Começa chamando a função `download_data()` e na sequência faz a leitura do arquivo features.txt para identificar quais colunas e índices contém as palavras "mean" ou "std", passando por parâmetro esses vetores para a função `build_tibble()` criar as tibbles de treino e teste.
Criados esses dois conjuntos de dados, o script une-os e atualiza os valores de status de atividade de inteiros para as suas referências em string (através do arquivo "activity_labels.txt.txt). O script chama essa função para o objeto "data", que por sua vez irá armazenar o conjunto de dados solicitado.

4. `tidy_data(data)`: Recebe como parâmetro o dataset criado por `run_analysis()` e transforma-o em um tidy dataset seguindo o requisitado pelo passo 5, isto é, agrupa os dados por tuplas únicas de subject e status, tirando as médias para os valores de cada um dos outros atributos. O objeto new_data irá armazenar esse novo dataset e, em seguida, será passado para um arquivo txt ("tidy_data.txt"), finalizando o script.


# Execução do script
1. Faça o download de run_analysis.R (ou clone o repositório, mas você só vai precisar desse script)
2. Mude seu diretório de trabalho para a pasta que fez o download do script.
3. Digite no seu terminal R `source('run_analysis.R')` e será gerada uma variável data com o requerido até o passo 4, além do novo arquivo tidy_data.txt

# Requerimentos
Foram utilizados os pacotes plyr (para uso da função mapvalues), dplyr, stats e stringr. Para executar o script você deverá baixá-los do [CRAN](https://cran.r-project.org/). Uma das maneiras é digitar as linhas abaixo no seu terminal R.

```R 
install.packages("plyr")
install.packages("dplyr")
install.packages("stats")
install.packages("stringr")
```