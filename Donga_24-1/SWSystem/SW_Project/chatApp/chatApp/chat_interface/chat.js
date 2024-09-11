// 중요! 소스코드의 경로에 한글이 있으면 안 됨
// npm init -y
// npm install ws

const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8080 });

wss.on('connection', function connection(ws) {
  ws.on('message', function incoming(message) {

    console.log('received: %s', message);

    // 받은 메시지를 모든 클라이언트에게 보냄
    wss.clients.forEach(function each(client) {
      if (client.readyState === WebSocket.OPEN) {
        // 받은 시간을 출력하기 위한 Date 객체 사용.
        const currentTime = new Date().toLocaleTimeString();
        client.send(message + '\t' + currentTime);
      }
    });
  });

  
});

console.log('Chat server is running on ws://localhost:8080');
