new Vue({
    el: "#app",
    data() {
        return {
            items: [],
            name: '',
            dimensions: '',
            productionDate: null,
            modal: false,
            id: null,
        };
    },
    methods: {
		findAll(){
			axios.get("/api/products")
				.then((response) => {
					this.items = response.data
					this.items.reverse()
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
        		this.resetForm();
        	})
        },
        cleanForm(){
            this.id = null;
            this.name = '';
            this.dimensions = '';
            this.productionDate = null;
        },
        resetForm(){
            this.cleanForm();
            this.findAll();
            this.modal = false;
        },
        edit(product){
            this.id = product.id;
            this.name = product.name;
            this.dimensions = product.dimensions;
            this.productionDate = this.formatDate(product.productionDate);
            this.modal = true;
        },
        formatDate(date) {
            var d = new Date(date),
                month = '' + (d.getMonth() + 1),
                day = '' + d.getDate(),
                year = d.getFullYear();

            if (month.length < 2)
                month = '0' + month;
            if (day.length < 2)
                day = '0' + day;

            return [year, month, day].join('-');
        },
        update(){
            axios.put('/api/products/' + this.id, {
                name: this.name,
                dimensions: this.dimensions,
                productionDate: this.productionDate
            })
            .then(() => {
                this.resetForm();
            })
        },
        submit(){
        if(this.id != null)
            this.update();
        else
            this.post();
        }
    },
	mounted(){
		this.findAll();
	}
});