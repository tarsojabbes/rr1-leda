package produto;

public interface RepositorioProduto {

    public boolean existe(int codigo);

    public void inserir(Produto produto);

    public void atualizar(Produto produto);

    public void remover(int codigo);

    public Produto procurar(int codigo);

}
