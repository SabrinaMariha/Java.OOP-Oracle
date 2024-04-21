import javax.swing.*;
import java.util.*;

public class Cartao {
    private double limite;
    List<ItemCompra> itens= new ArrayList<>();

    public Cartao(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }
    public void comprar(ItemCompra itemCompra){
        itens.add(itemCompra);
        limite -= itemCompra.getValor();

    }
    public void ordenarPeloPreco(){
        itens.sort(Comparator.comparing(ItemCompra::getValor));
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("*****************************\n");
        sb.append("COMPRAS REALIZADAS: \n\n");
        for(ItemCompra item: itens){
            sb.append(item.toString());
        }
        sb.append("\n\n*****************************\n");
        sb.append("Saldo do cartão: ");
        sb.append(this.getLimite());
        return sb.toString();
    }

}
