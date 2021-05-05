'use strict';

class LikeButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = {liked: false};
        this.clicked = this.clicked.bind(this);
    }
    clicked(){
        console.log("Clickedasdasdasd");
        this.setState({liked: true});
    }



    render() {
        if (this.state.liked) {
            return <h1>hiii</h1>;
        }
        return <button onClick={this.clicked}> Click me </button>;

    }

}
const domContainer = document.querySelector('#root');
ReactDOM.render(React.createElement(LikeButton), domContainer);