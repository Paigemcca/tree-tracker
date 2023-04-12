<template>
    <div>
    <div>
      <input type="file" ref="photoInput" @change="previewPhoto"/>
      <button @click="uploadPhoto">Upload Photo</button>
    </div>
    <div>
    <img v-if="photo" :src="photo" alt="uploaded photo" />
  </div>
  </div>
  </template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      photo: null
    }
  },
  methods: {
    previewPhoto() {
      // Get the selected photo
      let photo = this.$refs.photoInput.files[0]
      // Create a URL for the photo
      let photoUrl = URL.createObjectURL(photo)
      this.photo = photoUrl
    },
    async uploadPhoto() {
      let photo = this.$refs.photoInput.files[0]

      let formData = new FormData()
      formData.append('photo', photo)

      try {
        // Send the photo to the server
        let response = await axios.post('/upload', formData)
        console.log(response.data)
      } catch (error) {
        console.error(error)
      }
    }
  }
}
</script>