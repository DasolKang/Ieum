import { localSessionAxios, localSessionAxiosFormData } from '@/util/http-commons'
import { fail } from '@/api/fail.js'

const local = localSessionAxios()

const form = localSessionAxiosFormData()

const endpoint = 'i10a303.p.ssafy.io'

const url = `http://${endpoint}:443/api/sleepMode`

function getAllSleep(success) {
  local.get(`${url}`).then(success).catch(fail)
}

function postSleep(data, success) {
  local.post(`${url}`, JSON.stringify(data)).then(success).catch(fail)
}

function modifySleep(data, success) {
  form.put(`${url}`, data).then(success).catch(fail)
}
function deleteSleep(sleep_info_no, success) {
  local.delete(`${url}/${sleep_info_no}`).then(success).catch(fail)
}

export { getAllSleep, postSleep, modifySleep, deleteSleep }