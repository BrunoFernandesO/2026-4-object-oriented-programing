package br.com.nexuscloud.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.nexuscloud.exception.CapacidadeExcedidaException;
import br.com.nexuscloud.exception.ServidorOfflineException;

// classe do servidor virtual, que hospeda varios containers - RA: 25291321-2
public class Servidor {

    // ip e o identificador do servidor, final porque nao pode mudar - RA: 25291321-2
    private final String ip;
    private double precoPorHora;
    private double ramTotal;
    private boolean statusLigado;
    // lista ja instanciada na declaracao pra nunca dar NullPointerException, ArrayList mantem a ordem de chegada - RA: 25291321-2
    private List<Container> containers = new ArrayList<>();

    // construtor, o servidor nasce desligado (statusLigado = false) - RA: 25291321-2
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
        this.statusLigado = false;
    }

    // liga o servidor - RA: 25291321-2
    public void ligar() {
        statusLigado = true;
    }

    // desliga o servidor - RA: 25291321-2
    public void desligar() {
        statusLigado = false;
    }

    // aloca um container validando antes (fail-fast): primeiro se esta ligado, depois se tem ram sobrando - RA: 25291321-2
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // se estiver desligado lanca a unchecked ServidorOfflineException - RA: 25291321-2
        if (!statusLigado) {
            throw new ServidorOfflineException("Erro: Não é possível alocar containers em um servidor desligado.");
        }
        // se a ram em uso + a ram do novo container passar da ram total lanca a checked CapacidadeExcedidaException - RA: 25291321-2
        if (calcularRamEmUso() + c.getRamNecessaria() > ramTotal) {
            throw new CapacidadeExcedidaException("Falha Crítica: Memória RAM insuficiente no servidor " + ip + ".");
        }
        // passou nas duas validacoes, entao adiciona na lista - RA: 25291321-2
        containers.add(c);
    }

    // soma a ram de todos os containers usando stream: mapToDouble pega a ram de cada um e sum soma tudo - RA: 25291321-2
    public double calcularRamEmUso() {
        return containers.stream().mapToDouble(c -> c.getRamNecessaria()).sum();
    }

    // getters usados pelo CloudManager e pelo main - RA: 25291321-2
    public String getIp() {
        return ip;
    }

    public double getPrecoPorHora() {
        return precoPorHora;
    }

    public boolean isStatusLigado() {
        return statusLigado;
    }

    // dois servidores sao iguais se tiverem o mesmo ip - RA: 25291321-2
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Servidor outro = (Servidor) obj;
        return ip.equals(outro.ip);
    }

    // hashCode so com o ip, campos que mudam (status, ram) ficam de fora pra nao "perder" o objeto no Set - RA: 25291321-2
    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }
}
