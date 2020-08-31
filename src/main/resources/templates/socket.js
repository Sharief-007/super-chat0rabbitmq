let ws = new SockJS("/ws")

let client = Stomp.over(ws)

client.connect({},(frame)=>{
    client.subscribe('/topic/active',(message)=>{
        console.log(message.body)
    },{})
})
