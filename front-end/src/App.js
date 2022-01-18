import { Component } from 'react';
import Users from './Users';
import Form from './Form';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
          users: []
        }

        this.handleAddUser = this.handleAddUser.bind(this);
    }

    handleAddUser(element) {
        this.setState({
            users: [
                ...this.state.users,
                element,
            ]
        })
    }

    componentDidMount() {
        this.fetchUsers();
    }

    async fetchUsers() {
        const response = await fetch("http://localhost:8080/users");
        const resJson = await response.json();
    
        resJson.forEach(element => {
          this.setState({
            users: [
              ...this.state.users,
              element,
            ]
          })
        })
        console.log(this.state.users)
    }

    render() {
        return (
            <div>
                <Users users={this.state.users}/>
                <br/><br/>
                <Form onUserAdd={this.handleAddUser}/>
            </div>
        )
    }
}

export default App;