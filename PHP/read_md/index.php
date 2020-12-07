<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <title>Título da página</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </head>
  <body>
    <?php

    $baseDir = 'conteudo/';
    $abreDir = (array_key_exists('dir', $_GET) ? $_GET['dir'] : $baseDir);
    $openDir = dir($abreDir);

    echo '<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item">'.$abreDir.'</a></li>
    </ol>
    </nav>';

    while($arq = $openDir -> read()){

      if($arq != '.' && $arq != '..' && $arq != 'img'){        
        //GERENCIADOR DE PASTAS
        if(is_dir($abreDir.$arq)){
          echo "<div class='card' style='width: 18rem;'>
          <div class='card-body'>
          <h5 class='card-title'>".$arq."</h5>
          <p class='card-text'>Texto padrão</p>
          <a href='index.php?dir=".$abreDir.$arq."/' class='btn btn-primary'>Ir para ".$arq."</a>
          </div>";
        }
        
        //LEITOR DE MARKDOWN
        if(substr($arq, -2) == 'md'){        
          //Variável $fp armazena a conexão com o arquivo e o  tipo de ação.

          //Caminho no servidor para o arquivo
          $caminhoArquivo = $abreDir.$arq;

          $fp = fopen($caminhoArquivo, "r");
      
          //Lê o conteúdo do arquivo aberto.
          $conteudo = fread($fp, filesize($caminhoArquivo));
              
          //Fecha o arquivo.
          fclose($fp);
              
          //Variável que contém o texto do arquivo md
          $texto = $conteudo;
      
          /* ----------------CONVERSÃO PARA MARKDOWN---------------- */
      
          //Pegando código-fonte do conversor markdown
          require_once('vendor\erusev\parsedown\Parsedown.php');
      
          //Criando Objeto que contém as funções de conversão para markdown
          $Parsedown = new Parsedown();
      
          //Convertendo o texto de uma string para markdown
          echo $Parsedown->text($texto); # prints: <p>Hello <em>Parsedown</em>!</p>

        }
      }
    }

    if($abreDir != $baseDir){
      echo "<hr><a href='javascript:void(0)' onClick='history.go(-1); return false;'>voltar</a>";    
    }

    $openDir ->close();

    ?>

  </body>
</html>