'use strict';

function LikeButton(props) {
    const [liked, setLiked] = React.useState(false)
    const clicked = function () {
        setLiked(!liked);
    }

    return (
        <div>
            <button onClick={clicked}> Click me</button>
            <h1>button state:</h1>
            <h1>{liked ? "True" : "False"}</h1>
        </div>
    );

}