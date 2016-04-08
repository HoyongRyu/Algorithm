import React, {Component} from 'react';
import { Modal } from 'react-bootstrap';

export default class SuccessPopup extends Component {
  render() {
    console.log("show : " + this.props.show);
    return (
      <Modal show={this.props.show} onHide={this.props.close} className="modal modal-primary">
        <Modal.Header className="modal-header" closeButton>
          <Modal.Title>
            <span className="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>&nbsp;
            처리 완료
          </Modal.Title>
        </Modal.Header>
        <Modal.Body className="modal-body">
          <div>
          {this.props.message}
          </div>
        </Modal.Body>
        <Modal.Footer className="modal-footer">
          <button className="btn btn-outline pull-right" onClick={this.props.close}>Close</button>
        </Modal.Footer>
      </Modal>
    );
  }
}

