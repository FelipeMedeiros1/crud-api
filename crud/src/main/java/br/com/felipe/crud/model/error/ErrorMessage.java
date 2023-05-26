package br.com.felipe.crud.model.error;

public class ErrorMessage {

  private String titulo;
  private String mensagem;
  private Integer status;
    
public ErrorMessage(String titulo, String mensagem, Integer status) {
    this.titulo = titulo;
    this.mensagem = mensagem;
    this.status = status;
  }

    //#region Getters Setters
    /**
     * @return String return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return String return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return Integer return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    //#endregion

}