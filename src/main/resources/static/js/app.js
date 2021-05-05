'use strict';

class LikeButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = {liked: false};
        this.clicked = this.clicked.bind(this);
    }

    clicked() {
        console.log("Clickedasdasdasd");
        this.setState({liked: !this.state.liked});
    }

    render() {
        return (
            <div>
                <button onClick={this.clicked}> Click me</button>
                <h1>button state:</h1>
                <h1>{this.state.liked ? "True" : "False"}</h1>
            </div>
        )
            ;
    }

}

const domContainer = document.querySelector('#root');
ReactDOM.render(React.createElement(LikeButton), domContainer);