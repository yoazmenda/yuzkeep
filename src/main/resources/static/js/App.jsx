'use strict'
function App() {
    return (
        <LikeButton/>
    )
}
const domContainer = document.querySelector('#root');
ReactDOM.render(React.createElement(App), domContainer);