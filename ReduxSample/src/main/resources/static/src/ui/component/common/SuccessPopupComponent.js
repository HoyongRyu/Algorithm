import React, {Component} from 'react';
import { Modal } from 'react-bootstrap';

export default class ErrorPopup extends Component {
  render() {
    return (
      <Modal show={this.props.show} onHide={this.props.close}>
	    <Modal.Header closeButton>
	      <Modal.Title>
	        <span className="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>&nbsp;
	        처리 완료
	      </Modal.Title>
	    </Modal.Header>
	    <Modal.Body>
	      <div>
	      {this.props.message}
	      </div>
	      <button className="btn btn-primary" onClick={this.props.close}>Close</button>
	    </Modal.Body>
	  </Modal>
    );
  }
}
