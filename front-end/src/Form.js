import { Component } from 'react';

class Form extends Component {
    constructor(props) {
        super(props);
        this.state = {
            firstNameValue: '',
            lastNameValue: '',
            emailValue: ''
        };

        this.handleFirstNameChange = this.handleFirstNameChange.bind(this);
        this.handleLastNameChange = this.handleLastNameChange.bind(this);
        this.handleEmailChange = this.handleEmailChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleFirstNameChange(event) {
        this.setState({firstNameValue: event.target.value});
    }

    handleLastNameChange(event) {
        this.setState({lastNameValue: event.target.value});
    }

    handleEmailChange(event) {
        this.setState({emailValue: event.target.value});
    }
    
    async handleSubmit(event) {
        event.preventDefault();
        //tutaj wysylamy fetcha do api
        const data = {
            firstName: this.state.firstNameValue,
            lastName: this.state.lastNameValue,
            email: this.state.emailValue
        }

        const fetchOptions = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }

        const response = await fetch('http://localhost:8080/users', fetchOptions);
        const resJson = await response.json();
        console.log(resJson)

        const propsData = {
            firstName: resJson.firstName,
            lastName: resJson.lastName,
            email: resJson.email,
            id: resJson.id
        }
        this.props.onUserAdd(propsData);
    }
    
      render() {
        return (
          <form onSubmit={this.handleSubmit}>
            <label>
              Imię:
              <input type="text" value={this.state.firstNameValue} onChange={this.handleFirstNameChange} />
            </label>
            <label>
              Nazwisko:
              <input type="text" value={this.state.lastNameValue} onChange={this.handleLastNameChange} />
            </label>
            <label>
              Email:
              <input type="text" value={this.state.emailValue} onChange={this.handleEmailChange} />
            </label>
            <input type="submit" value="Wyślij" />
          </form>
        );
      }
}

export default Form;