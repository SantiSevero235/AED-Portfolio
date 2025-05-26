import java.util.LinkedList;
import java.util.List;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        LinkedList<TAbonado> abonados = new LinkedList<>();
        if (raiz != null) {
            raiz.buscarTelefonos(pais + area, abonados);
        }
        return abonados;
    }

    @Override
    public void insertar(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrieTelefonos();
        } else{
            raiz.insertar(unAbonado);
        }
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

}
