package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogoDAO;
import entidade.Jogo;

	@ManagedBean
	public class JogoBean {
		
		private Jogo jogo = new Jogo();
		private List<Jogo> jogo1;

		public String salvar() {
			try {
				JogoDAO.salvar(jogo);
				jogo = new Jogo();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "jogo salvo com sucesso."));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar o jogo."));
			}
			return null;
		}
		
		public String editar() {
			try {
				JogoDAO.editar(jogo);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "jogo editado com sucesso."));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao editar o jogo."));
			}
			return null;
		}
		
		public String excluir() {
			try {
				JogoDAO.excluir(jogo);
				jogo1.remove(jogo);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "jogo deletado com sucesso."));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao excluir o jogo."));
			}
			return null;
		}

		
		
		
		
		
		public Jogo getJogo() {
			return jogo;
		}

		public void setJogo(Jogo jogo) {
			this.jogo = jogo;
		}

		public List<Jogo> getJogo1() {
			
			if (jogo1 == null) {
				jogo1 = JogoDAO.listar();
			}
			return jogo1;
		}

		public void setJogo1(List<Jogo> jogo1) {
			this.jogo1 = jogo1;
		}
	}
		

	



