import java.text.SimpleDateFormat;
import java.util.*;

public class Chamada {

    private Date data;
    private Integer duracao;

    public Chamada(Date data, Integer duracao) {
        super();
        this.data = data;
        this.duracao = duracao;
    }

    public Date getData() {
        return data;
    }

    public Integer getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        return "Chamada: data = " + dataFormatada.format(data) + ", duração = " + duracao + " minutos";
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, duracao);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Chamada other = (Chamada) obj;
        return Objects.equals(data, other.data) && Objects.equals(duracao, other.duracao);
    }

    public static void main(String[] args) {
        GregorianCalendar ca = new GregorianCalendar();
        ca.set(2018, GregorianCalendar.DECEMBER,12);

        GregorianCalendar ca2 = new GregorianCalendar();
        ca2.set(2020,GregorianCalendar.APRIL,3);

        Chamada chamada1 = new Chamada(ca.getTime(), 50);
        Chamada chamada2 = new Chamada(ca2.getTime(), 30);

        Set<Chamada> chamadas = new HashSet<>();

        chamadas.add(chamada1);
        chamadas.add(chamada2);

        System.out.print(chamadas);

    }
}