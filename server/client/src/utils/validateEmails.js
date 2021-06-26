const re = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

export default (emails) => {
    emails = emails.trim();
    if (emails.length > 0 && emails[emails.length - 1] === ',') {
        emails = emails.slice(0, -1);
    }
    const invalidEmails = emails.split(',').map(email => email.trim()).filter(email => re.test(email) === false)
    if (invalidEmails.length) {
        return `These email are invalid: ${invalidEmails}`;
    }
    return ;
}