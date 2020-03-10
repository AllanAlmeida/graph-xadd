package br.radixeng.enums;

public enum Values {
		
		GRAPH_NOT_FOUND("GRAPH_NOT_FOUND");
		
		public String code;
	    
		Values(String code) {
			this.code = code;
	    }
		
		public String getCode(){
			return code;
		}
	}