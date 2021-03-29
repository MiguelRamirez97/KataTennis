
public class TennisGame3 implements TennisGame {
    
    private int P2point;
    private int P1point;
    private String[] puntos = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private String Player1Name;
    private String Player2Name;

    public TennisGame3(String p1N, String p2N) {
        this.Player1Name = p1N;
        this.Player2Name = p2N;
    }

    public String getScore() {
        String score = "";
        if (CondicionJuego()){
            score = EmpateOJuego();
        } else {
            if (CondicionPuntojeIgual()) {
                return "Deuce";
            }
            score = VentajaOGanador();
        }
        return score;
    }
    
    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.P1point += 1;
        else
            this.P2point += 1;
    }

    public boolean CondicionJuego(){
        return P1point < 4 && P2point < 4 && !(P1point + P2point == 6);
    }

    public boolean CondicionPuntojeIgual(){
        return P1point == P2point;
    }

    public boolean CondicionVentaja(){
        return (P1point - P2point)*(P1point - P2point) == 1;
    }

    public String Empate(){
        return puntos[P1point] + "-All";
    }

    public String Puntuacion(){
        return puntos[P1point] + "-" + puntos[P2point];
    }

    public String MayorPuntacion(){
        return P1point > P2point ? Player1Name : Player2Name;
    }

    public String VentajaOGanador(){
        return (CondicionVentaja()) ? "Advantage " + MayorPuntacion() : "Win for " + MayorPuntacion();
    }

    public String EmpateOJuego(){
        return (CondicionPuntojeIgual()) ? Empate() : Puntuacion();
    }
}
