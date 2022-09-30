package produto;

public class RepositorioProdutoArray implements RepositorioProduto {
    private Produto[] produtos;

    private int index = -1;

    public RepositorioProdutoArray(int size) {
        this.produtos = new Produto[size];
    }

    private int procurarIndice(int codigo) {
        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] == null) {
                return -1;
            }
            if (this.produtos[i].getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public boolean existe(int codigo) {
        for (Produto p : this.produtos) {
            if (p != null && p.getCodigo() == codigo) return true;
        }
        return false;
    }

    public void inserir(Produto produto) {
        if (index + 1 == this.produtos.length) {
            return;
        }
        this.produtos[index] = produto;
        index++;
    }

    public void atualizar(Produto produto) {
        int indice = procurarIndice(produto.getCodigo());
        if (indice == -1) {
            throw new RuntimeException();
        }
        this.produtos[indice] = produto;
    }

    public void remover(int codigo) {
        int indice = procurarIndice(codigo);
        if (indice == -1) {
            throw new RuntimeException();
        }
        this.produtos[indice] = null;
        moveProdutosParaEsquerda(indice);
        index--;
    }

    public Produto procurar(int codigo) {
        for (Produto p : this.produtos) {
            if (p != null && p.getCodigo() == codigo) return p;
        }
        throw new RuntimeException();
    }

    private void moveProdutosParaEsquerda(int indiceInicio) {
        for (int i = indiceInicio; i < this.produtos.length; i++) {
            this.produtos[i] = this.produtos[i + 1];
        }
    }
}
