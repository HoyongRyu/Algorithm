import React, {Component} from 'react';
import { Link } from 'react-router';
import { Form, TextInput } from 'react-easy-form';
import { Modal, Alert } from 'react-bootstrap';

const ErrorModal = ({message, show, close}) => (
  <Modal show={show} onHide={close}>
    <Modal.Header closeButton>
      <Modal.Title>
        <span className="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>&nbsp;
        Error
      </Modal.Title>
    </Modal.Header>
    <Modal.Body>
      <div className="alert alert-warning" role="warning">
        {message}
      </div>
      <button className="btn btn-default" onClick={close}>Close</button>
    </Modal.Body>
  </Modal>
);

const SuccessModal = ({headerMessage, bodyMessage, show, close}) => (
  <Modal show={show} onHide={close}>
    <Modal.Header closeButton>
      <Modal.Title>
        <span className="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>&nbsp;
        등록 완료
      </Modal.Title>
    </Modal.Header>
    <Modal.Body>
      <div className="alert alert-warning" role="warning">
        {bodyMessage}
      </div>
      <button className="btn btn-primary" onClick={close}>Close</button>
    </Modal.Body>
  </Modal>
);

export default class SignUpComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isErrorShow: false,
      isSuccesShow: false
    };
  }

  componentWillReceiveProps(nextProps) {
    this.setState({
      isErrorShow: !nextProps.isSuccess,
      isSuccesShow: nextProps.isSuccess
    });
  }

  render() {
    return (
      <div>
        <div className="well">
          <div className="row">
            <div className="col-md-12">
              <div className="col-md-7 text-center">
                <br/><br/>
                <h2>BAS Admin 회원 가입</h2>
                <p>가입 신청 후 관리자의 승인이 완료되면 로그인이 가능합니다.</p>
                <br/><br/>
              </div>
              <div className="col-md-5">
                <Form ref="form" onSubmit={(formData) => this.handleSubmit(formData)} className="pure-form pure-form-aligned">
                  <div className="form-group">
                    <label className="control-label">Email address</label>
                    <TextInput className="form-control" name="loginId" type="email" placeholder="Enter email" required />
                  </div>
                  <div className="form-group">
                    <label className="control-label">Password</label>
                    <TextInput className="form-control" name="password" type="password" placeholder="Password" required />
                  </div>
                  <Link to="/" className="btn btn-default">Back</Link>&nbsp;
                  <button type="submit" className="btn btn-primary">Sign Up For BAS Admin</button>
                </Form>
              </div>
            </div>j
          </div>
        </div>
        <SuccessModal message={this.props.message} show={this.state.isSuccesShow} close={this.props.closeErrorPopup} />
        <ErrorModal message={this.props.message} show={this.state.isErrorShow} close={this.props.closeErrorPopup} />
      </div>
    );
  }

  handleSubmit(formData) {
    const { loginId, password } = formData;
    const { signUp } = this.props;
    signUp(loginId, password);
  }


}