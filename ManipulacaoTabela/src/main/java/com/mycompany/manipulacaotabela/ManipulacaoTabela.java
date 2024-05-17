/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.manipulacaotabela;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author yuriz
 */
public class ManipulacaoTabela {
    
    private static String arquivo = "C:\\pessoa.csv";

    public static void main(String[] args) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            
            String linha;
            //nome;idade;cpf;rg;data_nasc;sexo;signo;mae;pai;email;senha;cep;endereco;numero;bairro;cidade;estado;telefone_fixo;celular;altura;peso;tipo_sanguineo;cor

            while((linha = br.readLine()) != null){
                String[] campos = linha.split(";");
            }
        }catch (IOException ex){
            System.out.println("Algo deu errado" + ex.getMessage());
        }
    }
}
