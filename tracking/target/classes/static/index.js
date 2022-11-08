new Vue({
    el: "#app",
    data() {
        return {
            items: [],
            name: '',
            dimensions: '',
            productionDate: null
        };
    },
    methods: {
		findAll(){
			axios.get("/api/products")
				.then((response) => {
					this.items = response.data
				});
		},
		post() {
        	axios
        	.post("/api/products", {
                name: this.name,
                dimensions: this.dimensions,
                productionDate: this.productionDate
            })
        	.then(() => {
        		this.name = '';
        		this.dimensions = '';
        		this.productionDate = null;
        		this.findAll();
        	})
        }
    },
	mounted(){
		this.findAll();
	}
});