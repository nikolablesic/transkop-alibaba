new Vue({
    el: "#app",
    data() {
        return {
            items: []
        };
    },
    methods: {
		findAll(){
			axios.get("/api/product-locations")
				.then((response) => {
					this.items = response.data
					this.items.reverse()
				});
		},
		connect(){
		var th = this;
		    var socket = new SockJS('/stomp-endpoint');
                stompClient = Stomp.over(socket);
                stompClient.connect({}, function (frame) {
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/location/new', function (greeting) {
                        th.items.splice(0,0,JSON.parse(greeting.body));
                    });
                });
		}
    },
	mounted(){
	    this.findAll();
		this.connect();
	}
});