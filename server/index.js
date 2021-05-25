const mongoose = require("mongoose");
const express = require("express");
const keys = require("./config/keys");
require("./models/User");
require("./services/passport");

const app = express();

require("./routes/authRoutes")(app);

mongoose
    .connect(keys.mongoURI, {
        useNewUrlParser: true,
        useCreateIndex: true,
        useUnifiedTopology: true,
    })
    .then(() => console.log('MongoDB connected...'))
    .catch(err => console.log(err));

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});