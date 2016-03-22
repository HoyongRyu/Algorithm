import React, {Component} from 'react';
import { Modal, Button } from 'react-bootstrap';

const ErrorPanel = ({errorCode}) => (
  <p className="error-panel">
    오류가 발생하였습니다. 관리자에게 문의하세요. 에러코드 : {errorCode}
  </p>
);

const objToString = (obj) => {
    var str = '';
    for (var p in obj) {
        if (obj.hasOwnProperty(p)) {
            str += p + '::' + obj[p] + '\n';
        }
    }
    return str;
}

export default class SignUpComponent extends Component {

  render() {
    const { modalShow } = this.props
    console.log("this.props: "+objToString(this.props));
    console.log("this.props.params: "+objToString(this.props.params));
    console.log("modalShow: "+modalShow);
    return (
      <Modal show={modalShow}>
        <Modal.Header closeButton>
          <Modal.Title>Sign Up</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <form role="form" onSubmit={(formData) => this.handleSubmit(formData)}>
            <div className="form-group">
              <label bsStyle="control-label">Email address</label>
              <input className="form-control" id="loginId"
              placeholder="Enter email" type="email" />
            </div>
            <div className="form-group">
              <label bsStyle="control-label">Password</label>
              <input className="form-control" id="password"
              placeholder="Password" type="password" />
            </div>
          </form>
        </Modal.Body>
        <Modal.Footer>
          <Button onClick={() => this.handleClose()}>Close</Button>
          <Button type="submit" bsStyle="primary">Sign Up For BAS Admin</Button>
        </Modal.Footer>
      </Modal>
    );
  }

  handleSubmit(formData) {
    const { loginId, password } = formData;
    const { login } = this.props;
    login(username, password);
  }

  handleClose(){
    const { modalClose } = this.props;
    modalClose();
  }

}


