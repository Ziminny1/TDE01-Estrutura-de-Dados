import java.util.Random;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);

    Pilha A = new Pilha();
    Pilha B = new Pilha();
    Pilha C = new Pilha();
    Pilha[] pilhas = new Pilha[3];

    pilhas[0] = A;
    pilhas[1] = B;
    pilhas[2] = C;

    Pilha D = new Pilha();
    Pilha E = new Pilha();
    Pilha F = new Pilha();
    Pilha[] pilhasInicial = new Pilha[3];

    pilhasInicial[0] = D;
    pilhasInicial[1] = E;
    pilhasInicial[2] = F;

    int decisao = 0;
    int n = 0;
    int tipo = 0;

    while (decisao != 1 && decisao != 2) {
      System.out.println("Escolha o modo de jogo: ");
      System.out.println("- (1) Organização Crescente ");
      System.out.println("- (2) Organização Decrescente");
      decisao = teclado.nextInt();
      if (decisao == 1) {
        tipo = 1;
      }
      if (decisao == 2) {
        tipo = 2;
      }
    }

    decisao = 0;

    while (decisao != 1 && decisao != 2 && decisao != 3) {
      System.out.println("Escolha a quantidade de discos: ");
      System.out.println("- (1) 2 Discos ");
      System.out.println("- (2) 3 Discos ");
      System.out.println("- (3) 4 Discos");
      decisao = teclado.nextInt();
      n = decisao + 1;
    }

    Random r = new Random();
    for (int i = 0; i < n; i++) {
      int randomNumber = r.nextInt(100) + 1;
      A.Inserir(randomNumber);
      D.Inserir(randomNumber);
    }

    boolean solucionado = false;
    boolean solucionadoAutomaticamente = false;
    int movimentos = 0;

    decisao = 1;
    if (tipo == 1) {

      while (decisao != 0 && !solucionado) {
        System.out.print("Pilha (1): ");
        A.Imprime();
        System.out.print("Pilha (2): ");
        B.Imprime();
        System.out.print("Pilha (3): ");
        C.Imprime();
        System.out.println("Movimentos: " + movimentos);
        System.out.println("Escolha uma operação: ");
        System.out.println("- (1) Movimentar");
        System.out.println("- (2) Solução Automática");
        System.out.println("- (0) Sair");
        decisao = teclado.nextInt();

        if (decisao == 1) {
          boolean valido = false;
          while (!valido) {
            valido = false;
            int primeiraEscolha = 1;
            System.out.println("- Insira o número da primeira pilha:");
            primeiraEscolha = teclado.nextInt();

            int segundaEscolha = 1;
            System.out.println("- Insira o número da segunda pilha:");
            segundaEscolha = teclado.nextInt();

            if ((primeiraEscolha > 0 && primeiraEscolha <= 3) && (segundaEscolha >= 0 && segundaEscolha <= 3)
                && (primeiraEscolha != segundaEscolha)) {

              int elemento = pilhas[primeiraEscolha - 1].getTopo();

              if (pilhas[primeiraEscolha - 1].getTopo() > 0) {

                if (pilhas[segundaEscolha - 1].getTopo() == 0) {
                  valido = true;
                  movimentos++;
                  pilhas[primeiraEscolha - 1].Remove();
                  pilhas[segundaEscolha - 1].Inserir(elemento);
                } else if (pilhas[primeiraEscolha - 1].getTopo() <= pilhas[segundaEscolha - 1].getTopo()) {
                  valido = true;
                  movimentos++;
                  pilhas[primeiraEscolha - 1].Remove();
                  pilhas[segundaEscolha - 1].Inserir(elemento);
                } else {
                  System.out.println("-Movimento Inválido");
                }

              } else {
                System.out.println("-Movimento Inválido");
              }

            } else {
              System.out.println("-Movimento Inválido");
            }

            if (!valido) {

              System.out.print("Pilha (1): ");
              A.Imprime();
              System.out.print("Pilha (2): ");
              B.Imprime();
              System.out.print("Pilha (3): ");
              C.Imprime();
              System.out.println("Movimentos: " + movimentos);
            }
          }
        }
        if (decisao == 2) {
          movimentos = SolucaoAutomaticaCrescente(pilhasInicial);
          solucionadoAutomaticamente = true;
          solucionado = true;
        }
        if ((A.checarOrdenacaoCrescente() && B.Tamanho() == 0 && C.Tamanho() == 0)
            || (A.Tamanho() == 0 && B.checarOrdenacaoCrescente() && C.Tamanho() == 0)
            || (A.Tamanho() == 0 && B.Tamanho() == 0 && C.checarOrdenacaoCrescente())) {
          solucionado = true;
        }
      }
    } else if (tipo == 2) {

      while (decisao != 0 && !solucionado) {
        System.out.print("Pilha (1): ");
        A.Imprime();
        System.out.print("Pilha (2): ");
        B.Imprime();
        System.out.print("Pilha (3): ");
        C.Imprime();
        System.out.println("Movimentos: " + movimentos);
        System.out.println("Escolha uma operação: ");
        System.out.println("- (1) Movimentar");
        System.out.println("- (2) Solução Automática");
        System.out.println("- (0) Sair");
        decisao = teclado.nextInt();

        if (decisao == 1) {
          boolean valido = false;
          while (!valido) {
            valido = false;
            int primeiraEscolha = 1;
            System.out.println("- Insira o número da primeira pilha:");
            primeiraEscolha = teclado.nextInt();

            int segundaEscolha = 1;
            System.out.println("- Insira o número da segunda pilha:");
            segundaEscolha = teclado.nextInt();

            if ((primeiraEscolha > 0 && primeiraEscolha <= 3) && (segundaEscolha >= 0 && segundaEscolha <= 3)
                && (primeiraEscolha != segundaEscolha)) {

              int elemento = pilhas[primeiraEscolha - 1].getTopo();

              if (pilhas[primeiraEscolha - 1].getTopo() > 0) {

                if (pilhas[segundaEscolha - 1].getTopo() == 0) {
                  valido = true;
                  movimentos++;
                  pilhas[primeiraEscolha - 1].Remove();
                  pilhas[segundaEscolha - 1].Inserir(elemento);
                } else if (pilhas[primeiraEscolha - 1].getTopo() >= pilhas[segundaEscolha - 1].getTopo()) {
                  valido = true;
                  movimentos++;
                  pilhas[primeiraEscolha - 1].Remove();
                  pilhas[segundaEscolha - 1].Inserir(elemento);
                } else {
                  System.out.println("-Movimento Inválido");
                }

              } else {
                System.out.println("-Movimento Inválido");
              }

            } else {
              System.out.println("-Movimento Inválido");
            }

            if (!valido) {

              System.out.print("Pilha (1): ");
              A.Imprime();
              System.out.print("Pilha (2): ");
              B.Imprime();
              System.out.print("Pilha (3): ");
              C.Imprime();
              System.out.println("Movimentos: " + movimentos);
            }
          }
        }
        if (decisao == 2) {
          movimentos = SolucaoAutomaticaDecrescente(pilhasInicial);
          solucionadoAutomaticamente = true;
          solucionado = true;
        }
        if ((A.checarOrdenacaoDecrescente() && B.Tamanho() == 0 && C.Tamanho() == 0)
            || (A.Tamanho() == 0 && B.checarOrdenacaoDecrescente() && C.Tamanho() == 0)
            || (A.Tamanho() == 0 && B.Tamanho() == 0 && C.checarOrdenacaoDecrescente())) {
          solucionado = true;
        }
      }
    }

    if (solucionadoAutomaticamente) {
      System.out.print("(1): ");
      D.Imprime();
      System.out.print("(2): ");
      E.Imprime();
      System.out.print("(3): ");
      F.Imprime();
      System.out.println("Total de Movimentos: " + movimentos);
      if (movimentos == 0) {
        System.out.println("TORRE ESTAVA PRE-ORDENADA");
      }
    } else if (solucionado) {
      System.out.print("(1): ");
      A.Imprime();
      System.out.print("(2): ");
      B.Imprime();
      System.out.print("(3): ");
      C.Imprime();
      System.out.println("Jogo Solucionado, Total de Movimentos: " + movimentos);
    }
  }

  public static int SolucaoAutomaticaCrescente(Pilha[] pilhas) {

    Pilha A = pilhas[0];
    Pilha B = pilhas[1];
    Pilha C = pilhas[2];

    int movimentos = 0;
    int ultimoMovido = 101;

    while (!((A.checarOrdenacaoCrescente() && B.Tamanho() == 0 && C.Tamanho() == 0)
        || (A.Tamanho() == 0 && B.checarOrdenacaoCrescente() && C.Tamanho() == 0)
        || (A.Tamanho() == 0 && B.Tamanho() == 0 && C.checarOrdenacaoCrescente()))) {

      Pilha menorPilha = null;
      int menor = 101;
      int menorIndice = 0;

      for (Pilha p : pilhas) {
        if (p.getTopo() > 0) {
          if (p.getTopo() < menor && p.getTopo() != ultimoMovido) {
            menor = p.getTopo();
            menorPilha = p;
          }
        }
      }
      if (menor == 101) {
        for (Pilha p : pilhas) {
          if (p.getTopo() > 0) {
            if (p.getTopo() < menor) {
              menor = p.getTopo();
              menorPilha = p;
            }
          }
        }
      }

      for (int i = 0; i < 3; i++) {
        if (pilhas[i] == menorPilha) {
          menorIndice = i;
        }
      }

      if (menorIndice == 0) {
        if (B.getTopo() >= menor || B.getTopo() == 0) {
          if (A.getAnterior() >= menor && A.getAnterior() <= B.getTopo() && C.getTopo() == 0) {
            C.Inserir(A.getTopo());
            A.Remove();
            movimentos++;
            B.Inserir(A.getTopo());
            A.Remove();
            movimentos++;
            B.Inserir(C.getTopo());
            C.Remove();
          } else {
            A.Remove();
            B.Inserir(menor);
          }

        } else if (C.getTopo() >= menor || C.getTopo() == 0) {
          A.Remove();
          C.Inserir(menor);
        }

      }

      if (menorIndice == 1) {
        if (C.getTopo() >= menor || C.getTopo() == 0) {
          if (B.getAnterior() >= menor && B.getAnterior() < C.getTopo()) {
            if (A.getTopo() > 0) {
              C.Inserir(B.getTopo());
              B.Remove();
            } else {
              A.Inserir(B.getTopo());
              B.Remove();
              movimentos++;
              C.Inserir(B.getTopo());
              B.Remove();
              movimentos++;
              C.Inserir(A.getTopo());
              A.Remove();
            }
          } else if (A.getTopo() >= menor && A.getTopo() <= C.getTopo()) {
            C.Inserir(A.getTopo());
            A.Remove();
            movimentos++;
            B.Remove();
            C.Inserir(menor);
          } else {
            B.Remove();
            C.Inserir(menor);
          }

        } else if (A.getTopo() >= menor || A.getTopo() == 0) {
          if (A.getTopo() == 0 && C.getTopo() <= B.getTopo() && C.getAnterior() <= B.getTopo()) {
            A.Inserir(C.getTopo());
            C.Remove();
            menor = A.getTopo();
          } else {
            B.Remove();
            A.Inserir(menor);
          }
        }
      }

      if (menorIndice == 2) {
        if (B.getTopo() <= C.getTopo() && B.getTopo() > 0 && B.getAnterior() <= C.getTopo() && B.getAnterior() > 0
            && A.getTopo() == 0) {
          C.Inserir(B.getTopo());
          B.Remove();
          menor = C.getTopo();
        } else if (B.getTopo() >= C.getTopo() && B.getAnterior() > 0) {
          B.Inserir(C.getTopo());
          C.Remove();
        } else if (A.getTopo() >= menor || A.getTopo() == 0) {
          C.Remove();
          A.Inserir(menor);

        } else if (B.getTopo() >= menor || B.getTopo() == 0) {
          C.Remove();
          B.Inserir(menor);
        }
      }

      ultimoMovido = menor;
      movimentos++;

      System.out.print("(1): ");
      A.Imprime();
      System.out.print("(2): ");
      B.Imprime();
      System.out.print("(3): ");
      C.Imprime();
      System.out.println("Menor: " + menor);
      System.out.println("Movimentos: " + movimentos);
      System.out.println("-------------------------------");

      if (movimentos > 10000) {
        System.out.println("JOGO INTERROMPIDO");
        break;
      }
    }
    return movimentos;
  }

  public static int SolucaoAutomaticaDecrescente(Pilha[] pilhas) {

    Pilha A = pilhas[0];
    Pilha B = pilhas[1];
    Pilha C = pilhas[2];

    int movimentos = 0;
    int ultimoMovido = 101;

    while (!((A.checarOrdenacaoDecrescente() && B.Tamanho() == 0 && C.Tamanho() == 0)
        || (A.Tamanho() == 0 && B.checarOrdenacaoDecrescente() && C.Tamanho() == 0)
        || (A.Tamanho() == 0 && B.Tamanho() == 0 && C.checarOrdenacaoDecrescente()))) {

      Pilha maiorPilha = null;
      int maior = -1;
      int maiorIndice = 0;

      for (Pilha p : pilhas) {
        if (p.getTopo() > 0) {
          if (p.getTopo() > maior && p.getTopo() != ultimoMovido) {
            maior = p.getTopo();
            maiorPilha = p;
          }
        }
      }
      if (maior == -1) {
        for (Pilha p : pilhas) {
          if (p.getTopo() > 0) {
            if (p.getTopo() > maior) {
              maior = p.getTopo();
              maiorPilha = p;
            }
          }
        }
      }

      for (int i = 0; i < 3; i++) {
        if (pilhas[i] == maiorPilha) {
          maiorIndice = i;
        }
      }

      if (maiorIndice == 0) {
        if (B.getTopo() <= maior || B.getTopo() == 0) {
          if (A.getAnterior() <= maior && A.getAnterior() >= B.getTopo() && C.getTopo() == 0) {
            C.Inserir(A.getTopo());
            A.Remove();
            movimentos++;
            B.Inserir(A.getTopo());
            A.Remove();
            movimentos++;
            B.Inserir(C.getTopo());
            C.Remove();
          } else {
            A.Remove();
            B.Inserir(maior);
          }

        } else if (C.getTopo() <= maior || C.getTopo() == 0) {
          A.Remove();
          C.Inserir(maior);
        }

      }

      if (maiorIndice == 1) {
        if (C.getTopo() <= maior || C.getTopo() == 0) {
          if (B.getAnterior() <= maior && B.getAnterior() > C.getTopo()) {
            if (A.getTopo() > 0) {
              C.Inserir(B.getTopo());
              B.Remove();
            } else {
              A.Inserir(B.getTopo());
              B.Remove();
              movimentos++;
              C.Inserir(B.getTopo());
              B.Remove();
              movimentos++;
              C.Inserir(A.getTopo());
              A.Remove();
            }
          } else if (A.getTopo() <= maior && A.getTopo() >= C.getTopo()) {
            C.Inserir(A.getTopo());
            A.Remove();
            movimentos++;
            B.Remove();
            C.Inserir(maior);
          } else {
            B.Remove();
            C.Inserir(maior);
          }

        } else if (A.getTopo() <= maior || A.getTopo() == 0) {
          if (A.getTopo() == 0 && C.getTopo() >= B.getTopo() && C.getAnterior() >= B.getTopo()) {
            A.Inserir(C.getTopo());
            C.Remove();
            maior = A.getTopo();
          } else {
            B.Remove();
            A.Inserir(maior);
          }
        }
      }

      if (maiorIndice == 2) {
        if (B.getTopo() >= C.getTopo() && B.getTopo() > 0 && B.getAnterior() >= C.getTopo() && B.getAnterior() > 0
            && A.getTopo() == 0) {
          C.Inserir(B.getTopo());
          B.Remove();
          maior = C.getTopo();
        } else if (B.getTopo() <= C.getTopo() && B.getAnterior() > 0) {
          B.Inserir(C.getTopo());
          C.Remove();
        } else if (A.getTopo() <= maior || A.getTopo() == 0) {
          C.Remove();
          A.Inserir(maior);

        } else if (B.getTopo() <= maior || B.getTopo() == 0) {
          C.Remove();
          B.Inserir(maior);
        }
      }

      ultimoMovido = maior;
      movimentos++;

      System.out.print("(1): ");
      A.Imprime();
      System.out.print("(2): ");
      B.Imprime();
      System.out.print("(3): ");
      C.Imprime();
      System.out.println("Maior: " + maior);
      System.out.println("Movimentos: " + movimentos);
      System.out.println("-------------------------------");

      if (movimentos > 10000) {
        System.out.println("JOGO INTERROMPIDO");
        break;
      }
    }
    return movimentos;
  }
}
