import {Component} from "react";
import './Users.css';

class Users extends Component {
    constructor(props) {
        super(props);
    }
    render() {
      const listItems = this.props.users.map((element, index) => {
        return (
          <tr key={index}>
            <td>{element.firstName}</td>
            <td>{element.lastName}</td>
            <td>{element.email}</td>
          </tr>
        )
      })
  
      return (
        <div>
          <h1>ADMIN TOOLS</h1>
            <table>
              <tbody>
              <tr>
                <th>Imie</th>
                <th>Nazwisko</th>
                <th>Email</th>
              </tr>
              {listItems}
              </tbody>
            </table>
        </div>
      )
    }
  }

  export default Users;