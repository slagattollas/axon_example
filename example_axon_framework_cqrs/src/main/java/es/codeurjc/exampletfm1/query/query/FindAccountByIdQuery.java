package es.codeurjc.exampletfm1.query.query;

public class FindAccountByIdQuery {
	private String id;

    public FindAccountByIdQuery(String id) {
        this.id = id;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
