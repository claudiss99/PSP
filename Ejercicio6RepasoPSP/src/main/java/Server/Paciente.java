/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Server;

import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Paciente {
private Socket socket;
    private Gestion gestion;

    public Paciente(Socket socket, Gestion gestion) {
        this.socket = socket;
        this.gestion = gestion;
    }
}
