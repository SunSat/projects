'use strict'
const ele = React.createElement;

class LikeButton extends React.Component {

    constructor(props) {
        super(props);
        this.state = {liked:false}
    }
    render() {
        if (this.state.liked) {
            return "I liked This";
        }
        return React.createElement(
            'button',
            {
                onClick: () => this.setState({liked: true})
            },
            'Like');
    }
}

var container = document.getElementById('like_button_container');
/*ReactDOM.render(React.createElement(LikeButton),container);*/
ReactDOM.render(React.createElement(
    "<h1>Hello World</h1>"
),document.getElementById('like_button_container'));
