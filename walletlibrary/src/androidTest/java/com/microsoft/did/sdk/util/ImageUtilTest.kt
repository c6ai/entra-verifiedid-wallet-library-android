// Copyright (c) Microsoft Corporation. All rights reserved

<<<<<<< HEAD
package com.microsoft.walletlibrary.did.sdk.util
=======
package com.microsoft.did.sdk.util
>>>>>>> dev

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ImageUtilTest {

    private val base64Images = arrayOf(
        "iVBORw0KGgoAAAANSUhEUgAAAOIAAAAgCAYAAAAPMKRoAAAAAXNSR0IArs4c6QAAAARzQklUCAgICHwIZIgAAA5gSURBVHic7Z17cFzVecB_392nVtJqZUm2ZethG_khbGzHBIhtHsaYl4ESIBlD3TApGdKQJtDQ6QwNbZghk4RkknTiSUtJk1CaEGimBGyexrJ5GIwwLwPGsmTJlmRLsrRaSavH7mpXu1__uHeVtayVZAwGh_ub0ezd833nO-dc73e-87j3WJgiqhoAroqFQmv76uqXx0M9czSVLADAcIQ9RdOaA9UL97gCgR0Oh-NpEembqm0bm886MpmCqi6MBYN3db762oaRSCRnsLkFp89HTmkpDq8HgGQsRrSjg5FojLzKCpw-X3TGBasf9RYV3SciDR97K2xsTnOyOqKq-hL9_d9v27b920Nt7S5PYQAxDEYiUeLhMEOHj5Do7wfA5feTW16Gu6AApy8HTaYY7usjd_asxOzL1m1y5ed_T0Qip6xVNjanGeM6oqrOD-159_Fg7e7FhtuFw-Ohb18dR1_aSSqRGNVzFwZAhFRihOTQEJpKYbhczLzoQgJnLiI5PEwqnmD6F87dm1u96Hqv13vglLXMxuY04jhHVNUV7S-8uDW8v77Y7fcz2NLK4SefRlMpClcsR5wuCpYspvmh3zFj3VoMl4vCs1cQen03htNJz5tvEevsQkQo_6uryasoJ97fT6B6UbB0zUWXi8g7n0RDbWw-zTgzv6jq_PYXXtza33Cg2FtURMsTWxg4eIiCsxaTN3cuI5EInuJinL4cnLk-DJeLZCxGoq8Pd2EhqeFhSi44H8Pt4ui27bQ-sYX8qjOovPYawvUNJcBWVV0lIo2fUHttbD6VjEZEVfWF9ry7u-u12sXeoiKafv8IsWCQ2dd_EU0kcOT6GGw8SCoWY7DpICNDQ8cYMjwe_NWLcObn4SksxFNSwlBrK53btpMzcwZnbLyJWCjE9JVf2Fu0fNl59pzRxubPGOmLRH__94O1uxe7_X5anthCtKuLsi9dz3BnF5pMEnr1NXreeJO-994_zgkBUsPD9O15l-5XdjFw4ADidKDJFIVnryB6tJPWzU_i9vsJ1u5ekggP3HtKW2lj8ynHAHOLom3b9m8bbheDLa0MHDzEzMsvJTU8TO68uRx9voahllZQndyiKv119Rx57HFyZs7AHSigaOV59Dc2Mdh6GMPtoq2m5nZVXfBxN87G5nTBAIgFg3cNtbW7HB4Ph598GnegAE9JMa7CAC0PP0IqHh83szMvF2de7riy4e4QHc9uJRWPkzdvLvkL5nN4y1M4PB4ibe2uSDB418fXLBub0wunqgZantiywVMYoG9fHZpKUbr-Snp2v4kmEujIyLE5RChYfCalV11ByYUXABB8aScdzzxH-IN9x0TNeG8vAw2NGB4P0y--iIEDjfTV7adgwXy6d9Vu6O3tvbOwsHDSJ3BUtQDIF5EjH2nrbWw-JYiqbmz6w6O_R5X99_-KVCJBTtls_NWL6KzZMepYroICZl56CaXrL8dXUTGusaGWVjqe3Urntu0kwmGzAMPAO3Mm0fZ2AAyXi0W3fR3EYM6GL210Op1_yFY5VXUAm4CvY67w7ge-LCJ7P8J7cEpQ1fOAZ4FSERm20n4GFIrILVO0cQ9giMg9H19NjyvzAeBtEXngVJX5WcQZC4XWDja34i0pHt2sjx5pI3qkbVRp0T_dyfS1azBcrgmN5VZWUPWNW5n3ta_Suf0F6n_6b2gqNeqEAKlEgpFIlFh3N4ne8FogqyMC_wD8DbAGaATuBsYfC58AqjoL2AtUiMjgydqbIk6gkGP3bn2cWHv2f6Q1mhrvYd57AFT1JuAWEbn0E6jLXyzOvrr65U5fDnErgo1Hx3PP455WeEKGgy_tzCqL9_fj8Hrpq69fnk1HVZ3AHcC9IvKqlXz7GB0DOAfoEpFDWewsAFJj9i4NjncKVNULfB44ICKdY2T5wGKgTkTCY2TLgYSIfJCtPSeCqrqAs4EPRGQgnS4i_3uCdvKApcCe8baLrA4pJiI91vfFQArYLyJqlfnvY7J5gPwTqYfN5BjxUM-cnNJShg5nn34NHTxEYmCQyJE2BpsOkkokGGhoJNYVJB7qYaChkWQ0xlBzK0Mtreb1oeas9iKHj-CbVUo8FJozQd0WAOXAU-MJVdWNOdT7P-B9Vf27MfKoqv4EeA7Yr6o3Zojfsz5bVfVyS3868BbwP0CDql6SYasKqAd-BNSr6uwM2W-A54FXVPW-CdozKap6s6rWAk8CjwF7VdWfIf9PVf0P6zpfVeOqem5G3n0ZuiuBFuC_gbdVtThD9rCq_hrYB5xppW0C_gQ8DtyXofuMqn7Xur4A-CVwtqr2qKpHVb-jqrsz9Hep6t-fzH34LGJoKlng8HpGH-Aej5GhIVx-P71vv8ORP20mcNZZHHrwIWLtHYxEIhx68CF8leV07niBrh0v4isvY7i7O6u9dETUVKpggrqlJ6KHs8g3AFXAfOAa4KeZP1ogBswQkXmY88ybM2SL02WIyFbr-k6gzdK_G9ikqumI-RWgRkQuBpaKSBuAqq4CvgwswYxgd57ktkzcsvNDq225wMXjKVqRshY430paCWzPUNkEfFdEFmDew1szZMPAdcBlIvKKquYA3wQutdry4yxl7gRuA94SkWnWXPdZ4HOq6ldVD7AC2HGiDf-sY0yu8omRrlsqi3wN8LyIxIAXgRHg3Ay5YvbwAHXAjEnKWwNstq43Y0aKdJ4gcK6qrhCRrow8FwO1ItIlIgeB98niOFNEgW4ReVlEopgRbfoE-tuA1db1SqAGQFULMYfYzap6NnAQ08HTpIDdIpKOZMNAGPgq4EwPVaeCiOzHdPTVVhndIlI31fw2JgaGI5yMxXD5_ZNrf0S4_X6S0RhiSPaJ6Z8j4ews8hKgF8Caz_Rw_I82HeaVyTudUXtAOpynHfHXwFbgZVW9PyNPcUYegNA4dUiT7lAcGWlOju9oMocmqTH6Y6kBVlvz10WYHRLATOvzh8ADmA4SHJO3NX0hIinMyH4DcEBVl05Q5ng8C1yE2RnY0fBDYHiKpjVHOzrILS87ZYX6ysuIdHTgLipunkCtAfPHc2UWeRCYBmANIYuAriy6U2HUHqZTAnQCiEhMRO7AHNLerKqfGycPmI6ZrQ5pRyjNSCs7yTq_AXiBjcA7GYtI6Y5kvYh83vq7bUzeZOYXEdkBLMeck__rCdYj0xG3T6JrMw5GoHrhnpFoDHdB9umaGAaDjU2kEgkcvhx63nob97RC4r29xI4exT2tkPDefYhhIIZB-APzOhtuv59kLEZhdXXWV6Ks-ccDwPdUdZGqOlX1R6p6jqWyA7hSVXOBdZgRb3cWc2OJWZ_lGWk7gBssp74B2CsiRwFU9Sxr_nnUymtk5FmpqrNUdT7m_CpbRDiEOUT8R1V1WYssa7CGkx8GERkBXsCc39ZkpAcxt2f-2qr_3dY-5rioqqGqK62RRQsTjx5iQFnG_BmrDkuAC7Ej4ofC6QoEduRVVtyCKobLdcyLv2lyymZTetUVlF51xWjaOb_58_5u5Vc2AlBy4fmjaUcee5zIOCuxhtuF05dD3pxKPNMCk_2j_QBrywCIYkaPhyzZH4GbMH84ucC3RCT7ilMGItKrqq8DO1X1RhHZBvwcszdvB_IwF4DS3Ah8A-gDXgfesezUqurvrPo5gJ-IyLgvP4tIUlVvxVyVvAVwA_8FPD2VOk_ANuCLHB-Jbgc2q-p3gATw4AQ25gJ_VNU-zIh9wwS6uzDvT7uqzrVGC0OquguYIyLZFtdsJkCsR9zaE_0DOeH6Btprjh9ZnPkv_4ynpHic7NkZ7gqy7wfHr-bPuvQS_Avm4ykoiFRce82ssXty46Gqc4EAZpRKjJEtAHpEJPsy7fg23cAcoElEklaaA3Ou1TJ2o19VSzGHofvSe2wZskpgJL2aOkm5fmAh5qLGuHufHxXWPmIV5r5gbBJdF-YCVauI9E6iWwAERKQlI-1XmPfgmydf888eAhDt7v5t08OP_q23aBp1v7wfTR27fuBftBDD6z0hw6lYjP799ccWZhhUf-s2hkM9zNt4429ziou_dpL1t_kUYHVgjcAdIrLlk67P6YiAGVWaH3t8bzwcdkU7u2h94uO5l5XXXYt3egmugoLErKvXL_F6vfYJb6c5qroO-Bnm0HyFiIz_qo7NhBgAItIw-7J1m1LxBHkV5eRXnXGMksPrJbBsaivahstFYNlSnLnHPkLpr6oit7yMVDzB7MvW_cJ2wr8YGoB7gNW2E354jjkqo2fPu693vla7xFtURNPDjxA92okzL5eSC84nEQ6TSowwMjhIKh5nqLkFTZor4M78fFz-fPIXzCfe24emUuRWlHP0-RpS8Tg5M2cyb-ONDIdCzFi18v1py5aeZ21Y29jYMOah51gsNr_ntdpXw_UNJZ7CQlo3P0l_YxMAeVVnULxqJcGdr-CrrKDn9Tdw5uVSsPhMNJlCXE7zrY22dnJmlTIyFCHa3o6_qoqKa69muLeXgoULgqVrLrIPj7KxGcMxp7h5vd4D1kPQW_vq9peUrb-CwdbDHN7yFINNB4l1duHKz8NwOEhGowSWL0NcLkYG-xgJRRhsbMKZn8fAgUbEMKi87lpyy8uIhUIEqhcFi1evutx2Qhub48l2wHCVdcDwktEDhuv2c_TFl4_ZZxSHwxyeioy-QGy4rQOGqzMOGF553vvTli293nZCG5vxmfjI_fDAvW01NbdH2tpd7kAB4nCYR-73h4kcbiNuvbHh9vvxlZfh9vtx-nJIJZMk-sLkmEfu_8JtHrlvzwltbLIwlf-EZkEkGLyre1fthsRQxDfY0oLD68U3qxSHtbeYjMaIdHSQjMXIm1OJy-eLTD9_1aOSl_dje3XUxmZyJnXENKoaSCaT6xO94bV99fXL46HQnPT7hGJI2F1U3FxYXf2O9djaM1N5YsbGxsbk_wH7XDUUXLgAwAAAAABJRU5ErkJggg",
        "iVBORw0KGgoAAAANSUhEUgAAAPUAAAAhCAYAAAABHu1cAAAAAXNSR0IArs4c6QAAAARzQklUCAgICHwIZIgAABIcSURBVHic7Z17dFTVvce_v31OJgOGGF5zEl5GiAozZ58zk4G2FKvBB9qqqJebwtLaC9pi67VV-6D2tdqltS_7Wi67urRee7ltbetjaW0VqXAFtEW5xJBzhhAkIhQJyYSEdx4z5-zf_YMZOoxJAEHoquezVtaa8_vt_du_fWbtM3v_9m-fEE6AZDJZ0tfXVw-AARAReQDKNE1b3tTUtPNEbAUEBLw30PEWtCzrXCKafejQod-2trb2F-pisdhcXdf7m5qalp96FwMCAk45yWRyUiwWWzBUGSnlRZZlXXq6fAoICDgJpJQLj6ecaZrzE4nEuPfYnYCAgCEQxyoQjUavHT58-LLjMZZKpR5n5usHLcB83NP9gICAd8dRg8y27dnMPJGZhVJKAchqmnYJM68DACGEl8lkXtm0adOWfJ14PF7hed4VQogyZlYALgCwh5nbiCjMzH2ZCz4Q7rjjkY-BqA-EVftm4WEQ8WntaUDA-wQCgHg8Xg3gKqXUasdxUnllLBabq2naq47jpAGgrq5O371792xN06YqpeKapr3peV5rNptdtnnz5gP5erZtL25qano4f12x4tCDXDr8P3OXvyTgsb0foVWno4MBAe83xMyZM0cppT66YcOGnxcOaADQNG1kfkADQHd39yhN085VSnX5vn-H7_uNmqaNCofDNYX1PM_rSyaTJflrDg3fn_9Mmb6LfYGjoucBAQGnDv3gwYPzXNd9qFhRU1NTqpTqA4BkMjnc87ybfN_fk0qlHgGgcsWWAUci37cBWOY4zluhUGiF53mXAFgOAKoUPxb9sImQCL_5emv74llrT0_3AgLeh0gpFw0iv_b8888fY1nWpZZlfbmmpqb0OGxdJ6W8EQANFjGXUl5smuaUk_M6ICBgMHQAIwdSCCFGDx8-fL5Saq3jOPfn5YlEYlw2m72SiCYw8x4iWuW6rgsArus-k0wmx8RisTuISA1kF8AOIpoI4M2TdT6RSIzzff8nzLzZdd1vnay900V9fb3W0tJS7rruPvxj1vMvgZTyLs_zfr9p06ZdZ9qX9ys6gAPFwkQiMdbzvMt831_c3Nx8EDicIprNZpeEw-FkVVVVTClVIYTo6-3tvVZK6RLR9xzHSTc0NOwG8DMp5cO1tbXJ119_vaHQdigUCvX19XlDOSWlvAdAmeu6XxiqXGNjY1symbw1k8n8CcBxDepoNBrSdd10HOf14yl_KolGo2VCiB-0tLTUANhpmuYYIURaKfX1VCrVcbr9OVlisZgdDoe3NDQ09BSItwohgpjJGUQws18oiMfj1b7v1wP4S35AA6BsNvu9c8455-OlpaXXzZo16_wFCxZE5syZM2nUqFGXVlVVfVII8YNYLDYqb0cp9adsNju5OMssk8l8KBwOrxvMofr6eg1AHQC7uro6fMp6mkMIMZKZf3iq7R6L-vp6TQjxpBBiueu6V7iue3MqlZrr-_6vACw93f6cCoQQ3-7r6zsq2ch13T9u3Lix-0z5FADozOxHo9FQc3NzJplMVu25KnvnoblUE9pEamzUerMz6bxsWdb8yZMnW1OmTLGWLFmC0tJ_LK8XLlyIZ599dtTTTz9d19raeheAbwJAaWlpq-d5ZzNzmZTyItd11wCAECLc0NCQHcyhlpaWKwCsIKJ9ZWVlcwE8XlzGsqwPAriMmduy2exzxfpYLGZrmjaLmUcBeNl13dUAEI_Hz_M871oA46WUizVNeymTyZyladoHdF3_c2NjY1vO_lxmrgyFQr9paGjokVLewMzDlFK_1nV9AYDJAF52HGdlblbzCSLSs9ns45s2bdo-UL82b958I4D1juM8WyjfuHHjX6WUvQUiMk3zKiGEzczbDhw48NS2bdv6gMMZe0RU7vv-UiHEJ4iIiehvzHwxEf3N931NCDGXmXdms9knCrcZk8nk2ZlM5npmrhJCvOY4zv_m7kmF7_sfZ-Ztvu-7uq5_kohWO47zaq7OVQBqmHmnEOL3juMcyvlyMxFVCyEWWJblOI7zrJTyWgBGKBT6Q0NDw77C74OILhdC9GSz2efy9ygWi80WQpxHRM8AMJVSHxFCvDVq1KjHVq1aNeRsLmBwBDM_RUQLksnk8L6-vvkH59I8Bq7qn0pXEtPlAMDMdiQSmfG1r30NpaWlWL16Ne6--260t7cDAObOnYvp06dPKi8vn2RZ1lkAkMlkun3fr3BddwUzl5umaVmWZTLzG8fwaaGmaf8D4HcAPlGsNE3z48x8D4C1RLS7-FdXSnmXEOJLADYT0Qpmvtk0zS_mfDpARNsB9ALY2t_ff1DX9d3MPMf3_al5G57n_R3Ap5VSFQBARG8S0Z2apn1fKdWllFrFzPdIKRdls9kfKaU2MPMWXdf_nEwmxwzUKWaex8yPDaQjolvzHy3L-p0QYjqAlQDOKisre7GmpqY8Z2MrgM9omvYTIYQvhNigaVo3gJHM_KAQYi4RvQjgrFAotDwajYYAwLbt8ZlMZhmADIDVAK41TfNnALB3794-HI5zfE_X9e8AaAHwtmVZE_r7-__CzIKZnycin5lfzM-emPktZu4hor8rpdoAwPf97QBu8DzPKPg-Fgkhvs3MDcy8Tdf1X9u2fSEAaJrWBqCOmX_KzNOEEC8w85Surq5HBrpPASdAPB5faJrm16PRaCiy3t4RWW9zZL3NY__PfhYAZsyY8ejy5ct57969vGXLFk4kEjx9-nR-5ZVXeM2aNbx3715ub2_nefPmPZf7FUUymRwupazPt2Hb9mei0eiXhvIjmUyOkVIeOeklpXymKJecpJRNyWTy7LwgFotFpZRr8temaX7RsqwJBTZLpJTrC_SGlHJFYbtSyh9blnVJkWxZYdumab5s23aioD8JKWVP4SC2LOvO3NbeO5BSNh1rB8E0zeullA8U1Vsopby34PrFWCw2u6je5VLK3xTJvmOa5k25Ov8lpbysUG9Z1lO2bX8AOPJddcycOXNYgf5c0zQ_X2Tz5_kBmbP7dCwWOypHQUr5B9u2z899HimlbKirq9Pz-kQiMc40zdcKbN4npVxSZMMtzHMIODEEACilupi5rLm5OcOsFgPYSRnqIsKDAEjXdc2yLADAoUOH4Hke-vv78dnPfhabNm0CAITDYVRVVXUCCAFAb2-vp5TS8g0ppbo0TRtyjdzf338DgN_nr5n5Mc_zbspfJxKJMQA6C6d24XD4qHPcqVTqx47jvJ1MJs-WUk7OZDIT8z6dLIcOHToSsdd1fTOAN3KBwby_bzDzOYPVD4VCQ6bGCiHqADxZKPN9_0lmriuUhcNht7guERVHm58H8KHc54TruiuK9E8qpQrttq5du_bIMsBxnLdSqdQD0Wg0ZJrmRCnlZCJSuSXNcUFECQCrCqfSjY2NbUR0YOrUqaPzMmZuLqq6vb-_v_J42wk4GoHDLzsYR0SPxGKxBZ0z3GXp6U0Txi727kpPb_oLAD5w4EDHzp07OwGguroa8-fPRygUQiKRwNVXXw0A8H0fmzdv9pRSbwBAaWnp2UR0AAASiYQNICOEWCelnDyoM0IsAnCZlPIhKeVDAK4CsDCv9zxvNIAhgzDRaHSSaZrPZjKZ-5l5PoB6Zj7lAbcRI0ZkAPhF4gwGeYAw83Zd188dSGdZViRXZjQRHdW_5ubmQ0Q04kT9E0J0EVF-FvGOgzu5dkYXywuLSCnv1TTtcSHELQDqAURPxIeB-pOjOxQKDbhMyeEJIfQh9AFDoFuW9W--7z-TSqU6LMsaJ6X8mOu6z3PBiSohRNuaNWteqKmpuQkAbr_9dtx---1HGVq3bt269vb2ffmtGaXUSKXUPsuyzvU8L-G67n8DgGVZnwKwtdgR27YTuQfCN_MyIgIzf8uyrA85jvNqb29v27Bhw8YP2SFd_ymA7zqO82peZlnWkGfBcfgASnmhgE_xiTIielopdQuAJQOofwFgHg7flwsAHEnXtSyrmpnffhdNTgDQBgDM3G9Z1ln5IFdONhVD5ArYtj1HKTXOdd3r8jIpZdkJ-rAVwDUDyGt6enq2naCtgONEKKUq8gPRcZyXiajPsqwrCwuVlJQ8vHTp0p4VK1asGcjIli1btt53333rhRCP5mVKqUmapgkhxGX5AZ0jM5ANpdQiInrYdd2thX_M_DAzLwSA1tbW_QD6pJQyXy-bzX6syNRIAEcGgWma85n5yC-SEOIggLMLKzBzI4Aja-poNDqJiKYP5Oe7ZfTo0b8molrTNOsK5VLKqfkHCjMvZeY7ksnk8JyamPkbAI4ZOGLmD-cDY7l6tzLzHwFACLFUKfXVgjZHMvON2Wz2qcHs-b5fAeDI0iYajVYCKD5We1DTtHIMguu6jQAmm6Y5raDt6wA0Fb89J-DUoVVVVSU6Ojoa84KOjo63qqqqDKXUNZ2dnX8GgF27dmUrKysbV69ePa2trW1DWVlZpru7G21tbdtXrly5_N57793S29v7mOM4RwJSkUjkFiGEampqerSwwTFjxoQmTZo0eteuXUcOipimeQsRLQHQnU6nVxaWr6ys_BSAT1VWVu7r6OhYX1VV9apS6mHDMC6NRCL1ADoBzDMMY1w6nV5uGMYOZn7UMIwPGoaxSAjRCiARiURC6XT6tY6OjmwkErkiEolcH4lEhqXTaSedTrcahnGDYRgLDcO4UtO0WgCdSqlrysvLl40fP_77AC4pKSmxx48f_9fx48eXHjhw4JdEND0SiUxKp9PPm6b5YSK6h5lrI5EI0un0UXvx27ZtUxMnTvyjUuorhmH8h2EYswzDuBnAhUR0e0dHx_50Or2nsrKyy_f9Bw3DmGkYxh1E9Jrruo_m7tMPiWiOUsoeO3bs2nQ6vT93r6cQ0XlCiKsjkcilhmF8GcDrqVTqVwBw0UUXvd7V1XW5YRh3RSKR2UR0G4CvNjc3t5imaSilHgIwo7KycnxHR8cLADBlypStmUxmiWEY1xiGcZ0Q4kIAawHcMHHixKd37drVH4lEsgDuNwwjmU6nn5NSfhPAtcwcj0Qijel0ujMSiawiop9VVlZeGYlEFjBzTNf1z7W3t_dJKRcT0SIAtYZhbE2n09tziUdXM7M9bty49e3t7cGe9wlClmV9yXGcHxUrpJRf8H0fuq4_VDBtE1LKeQAkM_tEpAFIZzKZpQV7omSa5o1EFHNd96vFduPxeLVSKuk4zqC_EsdDNBqt7Onp2Zvfwy0kl_1mlJSUdAyyJ06maU44ePBgZ2H9eDxekc1mxXudPFFdXR0eNmyYUVFRkS4MThUSjUYrY7FY5xNPPFG8bn8HpmleLoSY4zjOlxOJxLg9e_Z0D3Rf6urq9O7u7lGFJ--Ow7ZRWlraVxicLCQej1cQUUljY2PnUHbi8XiFpmmZouyzgPeC3Br3HcRisQUXXHDBCNu2by3eDhmMeDx-nmVZn89tW9w8SHu1pmme0qnt-x3TNC-3LOv-Y5cMeD9wJCp621g-Kgji-_6LJSUlFzc1NT0khOiybftz06ZNO28gIzU1NeW2bS9WSk1zHOcB3_f3CSEGfLIDqE2lUqc97_pflVgsNpuIvsLMF1uWdeeZ9ifgzKNX9t64PTnxlXUZxtu3jOeX9-_EA0-A_JaWli7TNEcCQFNTUyOARsuyrrQs6zIiWtnU1PRGdXV1RXl5-b8DyOq6_qv8VFcpdVVfX98LxY1NmzbtPGb-lzuZdCbZuHHjSwBeOtN-BPzzoE_qWXIFCDMAzCCovRUTxBy8ffjlB0SkampqSvORSsdxXqirq9M7Ozvvtm17qu_7-3p6er7d2tp61HpKCFGei1QfIRf1rCiKhAcEBJxi6NMT-RvMuBcAfNrftmP4g79Nl_5hMzPvB3AQh09MtQghAIA8z_OI6KVUKrUjl-c9l4jKcy8qhFKqTAgBItpBRMOYebRSyvc8b3lLS8ux8r4DAgJOErptLJdlSvELANMBLH3kbfo-AGFZ1hhmLtM07aOZTOaXzc3NA-4vFyOl_AKA55n50IgRI3YPFt0NCAg4Q0Sj0VDuFUXHxLbtCwsPPQQEBJx-jvky_-bm5ozv-1sSicRFQ5VLJpOTmHlCLqgWEBDwz05tbe1HEonEgP8ry7bt8wfblw4ICDi9nNChhdra2pr-_v4P67q-I5vNbiKiiUKIuKZp2zZs2PDie-VkQEDA8fOuTiJJKUcqpaLhcHh_Q0PDO872BgQEnDn-H1WI7XMDkklXAAAAAElFTkSuQmCC",
        "iVBORw0KGgoAAAANSUhEUgAAAGYAAAAZCAYAAADDq1t2AAAAAXNSR0IArs4c6QAAAARzQklUCAgICHwIZIgAAAZYSURBVGiB5ZpNbBxFFsd_1TO2xwmZ6YGwCktstwNCsCbgPYUEVulIiaJckH0IUpBWjqXcE3MBn9LeC-RC4sPeVsr4SpBia0_WRrhzghsGYWlXrJY2JsJ82eNskO2xZ4pDV49rerrbM52T8V9qeab7fVTXq_97r2osnH-9b2NgAVAzTKiZJMEwCkhpApS-_3LRq5QTxaPwz_x_eSP7qG09H7VScXjZS6m8Z5AFQBq3ARAARrKGrAtiF_uY-rG9wPQaFf7S-WvdRluQuObQstO-4t6D4Zwbd0G6aZStnElfLplgYbx74Ic0rgCQkrHUynsMPj2knEhrwM73tSx7PLPO210rqfwIQak4_GA-lfIehAHgnBt3qdWm0hiwciYnDj3bkuzfn1hK4wKAWrWaevHsRewUlCoOiPYrOWAXLHIimyhzqWuF49n1NOYVW37_BV9HPTDOhXEPWZ1MYyRnZDmRT2bNe49RW_YbWyDcgmVzt9Ky5rVDRzEzuchnl7pW6DUqacwia0zuN7ZAKDDOmbHy47DmfPG5pvu9RuUx2CI9qN5Kqbyn0bRpcc6NO4CXxtiLBw43tc-XcquPwRZjaj-yBeJ2k7I2mtag3j73GhXe615OaUl6xeHvnLTj2OuI3X479z6YA2G3YsTsznO6_3Vmv_6Eja1NPFnhtPUa65-_w9tdK3QcOU-mMMDGfz5s0MscPklX_xVER56t5Vkq__tH_ZmsMVocflACkFJeBWzABKaEECXdjpRyELiq3bofltFk27VVBiaFEF5IzlRytro1KYSY1p5bwHV1f167fxuYCWSllDYwEhrmF_HnL21sOje2Nnnx6RewzF4ARo6d4fLzZ_nrH54BoLPnLYzCQINOZ89Fnjh1B7m-xPbyLF3HrnDw1J3AuacF5SbgAPfVdVNKeS00BBO4DCyq67qagNAryeuarRkl58TYWlO2bGBOBULHXSU3o-TuqkkGQAVySMkE_m313dPsWKGxLwLl2M2Hc27cde7dmFbGE7Gxvcnyox_oK_bw75--xnqyB6CceeqkWV1bQBw4ytbSnQadzmNXqCx9xPpXDgDVtQUOvn6HTGGA7dWFCfUiJnANGA1WtpQS_JXY1BQIIRwl4-JP5pQQwtVELgNjmi2P5tUa4KYQYlFKWQK-AQYBV-nZ-AHrD5gkpSyocen-JpX9YCGNAJ7OoPDYAySfWG7Vxlptn5cf_oipCr9izmT28ElER55MYYDa2kKDfKYwwPb3s_Xv27986t9_8kSdLfiTATCtqU4DppQy9ixIBcPT9IPUYgHzmty0EGJ4l1ez1V9PuzcIlEPpbUb3p-AClsYkG4g8YZFSXtYuMzEw7Ww6vfK3WMUerGIv-C9fyj51EiPvp7Bg4hsGs_Ww6V738b81pVAhGhZHO6emUbKr4Od6KeWclHIuRteVUn4D3MZnmReyG7VgG_ypBTIP2Kp2WUApxt-Idlm7nPHT8qZzcXWJXLaLV4-8DH7x9URH3uvsvcj2z9FBEQd6okyVw59j2LG2y5DiJq9f_Z3CrzV2jP6EuqCRseCzJxz0OH8zwGn8NDofbiICCCHOaNf8roFpddO5sb1JeWONwT--DDt59n5nz1tUHy40yVcfLtDZc7H-vfPYleCjnmrm8V9WL_Yj-C8Yu1hUkTfRJlRNiKv09XQXhzlVi1x81ugI0qlef6_SHEDwGWIrvy1v3pNPHutSuVtUKyOgfumMgbe6xOAzBdgJjAuMVCMYs_75GAdPfcyhs58ht9bI-F3bRMSKGsXveAbxJ9sC_hzlX6UlS8mNRtgaU7bm8IMyRGOxjsIEfiNhB42EEKIspQxsueywJyoNe0rGTvIVSqnzLf-M6Ny7MYTfIsbiT0-_MHnxlSFX69FNYPD_s69cr22u2FE6HUfOIzryiO6-_u6XxryYQVv4hdUEpsNsUX6C1VsG3DhGhWx5oa5Nt1X3o5hRjpC12EmFTePS5AYBS9_nxNgIUG7r991dNp2ec_bd_qgHq3eP2sKILbIIQanw5oPUpw2_R-xe_HUkbTprtdhnxeHvXEQcjaW3H4_1d0NbgUn4_wCPanKullUROfn7-aAyCe0xBmBLRqQc6ToXxr0ktWjW7O-DyiS01pVpcC6Me869G8PI2s4udzt209QAWWUM9BbTcNv1v1_wG1U5qADvMTgHAAAAAElFTkSuQmCC"
    )

    private val dimensions = arrayOf(arrayOf(32, 226), arrayOf(33, 245), arrayOf(25, 102))

    private val testBitmap: Bitmap = createTestBitmap()

    private fun createTestBitmap(): Bitmap {
        val width = 200
        val height = 100

        val bitmap = Bitmap.createBitmap(200, 100, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        canvas.drawPaint(paint)

        paint.color = Color.WHITE
        paint.isAntiAlias = true
        paint.textSize = 14f
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText("Hello Android!", width / 2f, height / 2f, paint)
        return bitmap
    }

    @Test
    fun convertAndParseBitmap() {
        val base64Image = ImageUtil.convert(testBitmap)
        assertThat(base64Image).isNotNull
        val reconstructedBitmap = ImageUtil.parse(base64Image)
        assertThat(testBitmap.sameAs(reconstructedBitmap)).isTrue
    }

    @Test
    fun parseBase64Images() {
        for (i in base64Images.indices) {
            val bitmapImage = ImageUtil.parse(base64Images[i])
            assertThat(bitmapImage).isNotNull
            assertThat(bitmapImage!!.height).isEqualTo(dimensions[i][0])
            assertThat(bitmapImage.width).isEqualTo(dimensions[i][1])
        }
    }

    @Test
    fun passingNullReturnsNull() {
        assertThat(ImageUtil.parse(null)).isNull()
    }

    @Test
    fun passingInvalidStringReturnsNull() {
        val invalidString = "1" + base64Images[0]
        assertThat(ImageUtil.parse(invalidString)).isNull()
    }
}