
// ---------------------------------------------------
// Exercicio de Java
// Testa um ipv4 (192.168.1.1) para ver se eh valido
// usando apenas manipulacao de caracteres (charAt)
//
// Para simplificar:
// >> apenas verifica se he numero e se tem 3 pontos.
// >> nao eh feito validacao de faixa de numero (192.388.1.1)
// >> nao eh feito teste se tem mais pontos seguidos (192..168.1)
// >> nao identifica quais erros existem no ip
//---------------------------------------------------

import java.util.*;

public class verifIp {

public static void main(String[] argv) {

    String texto  = argv[0];
    String num_temp = "";
    int num[] = new int[4];
    Boolean valido = false;
    int ponto=0, numeros=0;

	for (int n = 0; n < texto.length(); n++) {
        if ( ( (texto.charAt(n) < '0') || (texto.charAt(n) > '9') ) &&
               (texto.charAt(n) != '.' )) {

                 //nao eh ponto nem numero. sai fora do loop
                 valido=false;
                 break;
        } else { 
            //caractere esta dentro da faixa de 0 a 9 ou eh um ponto

            if (texto.charAt(n) == '.') {
              //achou um ponto. converte para int
                
              //se tiver dois pontos seguidos erro na conversao
              num[numeros] = Integer.parseInt( num_temp ); 
              num_temp = "";
              numeros++;
              ponto++;

              if (numeros > 4) {
                  valido=false;
                  break;
              }

            } else {
              num_temp = num_temp + texto.charAt(n);
              valido=true;
            }
        }
    }
    if (ponto != 3) valido=false;

    if (valido) {
        System.out.println("Ip valido!!");
    } else {
        System.out.println("Ip com problemas!!");
    }

}

}
