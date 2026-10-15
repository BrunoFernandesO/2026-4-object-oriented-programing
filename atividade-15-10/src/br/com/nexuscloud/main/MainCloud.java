package br.com.nexuscloud.main;

import br.com.nexuscloud.exception.CapacidadeExcedidaException;
import br.com.nexuscloud.model.Cliente;
import br.com.nexuscloud.model.CloudManager;
import br.com.nexuscloud.model.Container;
import br.com.nexuscloud.model.Servidor;

// classe executavel com o roteiro de testes da atividade - RA: 25291321-2
public class MainCloud {

    // o main repassa a checked com throws, assim os passos 6 e 8 compilam sem try-catch (so o passo 9 trata com try-catch) - RA: 25291321-2
    public static void main(String[] args) throws CapacidadeExcedidaException {
        // passo 1: cria o gerenciador - RA: 25291321-2
        CloudManager manager = new CloudManager();

        // passo 2: cria o cliente - RA: 25291321-2
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // passo 3: cria o servidor com 16 de ram e preco 5.50 por hora - RA: 25291321-2
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // passo 4: registra o cliente e coloca o servidor no conjunto dele - RA: 25291321-2
        manager.registrarCliente(cliente);
        manager.provisionarServidor(cliente, servidor);

        // passo 5: cria os dois containers - RA: 25291321-2
        Container c1 = new Container("C-01", "App Batcomputador", 10.0);
        Container c2 = new Container("C-02", "App Batmovel", 8.0);

        // passo 6: o servidor nasce desligado, entao essa linha estoura ServidorOfflineException; foi testada e comentada pro programa seguir - RA: 25291321-2
        // servidor.alocarContainer(c1);

        // passo 7: liga o servidor - RA: 25291321-2
        servidor.ligar();

        // passo 8: agora o servidor esta ligado e tem ram, entao aloca o container 1 com sucesso - RA: 25291321-2
        servidor.alocarContainer(c1);
        System.out.println("Container " + c1.getId() + " alocado com sucesso! RAM em uso: " + servidor.calcularRamEmUso() + " GB");

        // passo 9: tenta alocar o container 2, 10 + 8 = 18 passa de 16, entao cai no catch e mostra a mensagem - RA: 25291321-2
        try {
            servidor.alocarContainer(c2);
            System.out.println("Container " + c2.getId() + " alocado com sucesso!");
        } catch (CapacidadeExcedidaException e) {
            System.out.println("[ALERTA] " + e.getMessage());
        }

        // passo 10: mostra a fatura ativa do cliente, deve dar 5.5 porque so tem 1 servidor ligado - RA: 25291321-2
        System.out.println("Fatura ativa de " + cliente.getNome() + ": R$ " + manager.calcularFaturaAtiva(cliente));
    }
}
