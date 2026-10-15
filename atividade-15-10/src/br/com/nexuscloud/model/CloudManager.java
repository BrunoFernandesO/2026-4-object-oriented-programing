package br.com.nexuscloud.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// banco de dados principal do sistema, guarda cada cliente com o conjunto de servidores dele - RA: 25291321-2
public class CloudManager {

    // Map declarado pela interface e instanciado com HashMap (baseado em hash), chave = Cliente, valor = Set de Servidores - RA: 25291321-2
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // construtor vazio, o map ja foi criado na declaracao - RA: 25291321-2
    public CloudManager() {
    }

    // registra o cliente com um HashSet vazio (sem duplicados e sem ordem) - RA: 25291321-2
    public void registrarCliente(Cliente c) {
        bancoDeDados.put(c, new HashSet<>());
    }

    // pega o set de servidores do cliente e adiciona o servidor nele - RA: 25291321-2
    public void provisionarServidor(Cliente c, Servidor s) {
        bancoDeDados.get(c).add(s);
    }

    // soma o preco por hora so dos servidores ligados do cliente: filter deixa passar os ligados, mapToDouble pega o preco e sum soma - RA: 25291321-2
    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados.get(c).stream()
                .filter(s -> s.isStatusLigado())
                .mapToDouble(s -> s.getPrecoPorHora())
                .sum();
    }
}
